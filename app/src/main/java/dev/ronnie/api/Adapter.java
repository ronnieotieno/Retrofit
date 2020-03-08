package dev.ronnie.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<TeamList> mList;
    private Context context;

    public Adapter(List<TeamList> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder adapterViewHolder, int i) {

        TeamList team = mList.get(i);


        adapterViewHolder.active.setText(team.active.toString());

        adapterViewHolder.details.setText(team.details);
        adapterViewHolder.group.setText(team.group);
        adapterViewHolder.key.setText(team.key);

        adapterViewHolder.title.setText(team.title.toString());


    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, key, active, group, details;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            key = (TextView) view.findViewById(R.id.key);
            active = (TextView) view.findViewById(R.id.status);
            group = (TextView) view.findViewById(R.id.group);
            details = (TextView) view.findViewById(R.id.details);
        }
    }


}