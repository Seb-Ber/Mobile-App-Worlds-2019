package com.vogella.android.worlds2019.Controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vogella.android.worlds2019.Modele.ItemData;
import com.vogella.android.worlds2019.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ItemData> values;
    private OnTeamListener monTeamListener;

    public MyAdapter(List<ItemData> itemsData, OnTeamListener onTeamListener) {
        values = itemsData;
        this.monTeamListener = onTeamListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView Logo;
        public View layout;

        OnTeamListener onTeamListener;

        public ViewHolder(View v, OnTeamListener onTeamListener) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            Logo = (ImageView) v.findViewById(R.id.icon);

            this.onTeamListener = onTeamListener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTeamListener.onTeamClick(getAdapterPosition());
        }
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v, monTeamListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ItemData itemData = values.get(position);
        final String name = itemData.getTitle();
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove(position);
            }
        });
        Picasso.get().load(itemData.getLogoUrl()).into(holder.Logo);
        final String seed = itemData.getSeed();
        holder.txtFooter.setText(seed);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public interface OnTeamListener{
        void onTeamClick(int position);
    }

}

