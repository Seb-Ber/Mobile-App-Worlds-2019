package com.vogella.android.worlds2019.Controller;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vogella.android.worlds2019.Modele.ItemData;
import com.vogella.android.worlds2019.R;

public class DetailsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ItemData itemData = getArguments().getParcelable(null);
        String name = itemData.getTitle();
        String player = itemData.getPlayer();
        System.out.println("DATA : "+ name);
        View rootView = inflater.inflate(R.layout.fragment_details, null);
        TextView nameView = (TextView) rootView.findViewById(R.id.TeamName);
        TextView playerView = (TextView) rootView.findViewById(R.id.Player);
        ImageView playerImage = rootView.findViewById(R.id.teamImage);
        nameView.setText(name);
        Picasso.get().load(itemData.getTeamUrl()).into(playerImage);
        playerView.setText(player);
        return rootView;
    }
}
