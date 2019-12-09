package com.vogella.android.worlds2019.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.vogella.android.worlds2019.Modele.ItemData;
import com.vogella.android.worlds2019.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamFragment extends Fragment implements MyAdapter.OnTeamListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Context mContext;
    private MyAdapter.OnTeamListener onTeamListener;

    private List<ItemData> itemDataList = new ArrayList<ItemData>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_team, null);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        String url = "https://raw.githubusercontent.com/Seb-Ber/repository-premier-app/master/data";
        mContext = getActivity().getApplicationContext();

        onTeamListener = this;

        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i=0; i<response.length();i++) {
                                JSONObject team = response.getJSONObject(i);
                                String name = team.getString("id");
                                String src = team.getString("logo");
                                String seed = team.getString("seed");
                                String team_image = team.getString("team");
                                String player = team.getString("player");

                                ItemData itemData = new ItemData(name, src, seed, team_image, player);
                                System.out.println("\n\nITEM DATA : " + itemData.getTitle() + "\n");
                                itemDataList.add(itemData);
                            }
                            mAdapter = new MyAdapter(itemDataList, onTeamListener);
                            recyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("ERREUR :" + error);
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
        return rootView;
    }

    @Override
    public void onTeamClick(int position) {
        System.out.println("CLICK");
        Intent intent = new Intent();
        intent.putExtra("selected_team", itemDataList.get(position));
        Fragment fragment = null;

        Bundle bundle = new Bundle();
        bundle.putParcelable(null, itemDataList.get(position));

        fragment = new DetailsFragment();
        fragment.setArguments(bundle);
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}