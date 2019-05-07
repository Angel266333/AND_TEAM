package com.andteam.sep4greenhouse.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.TestResponse;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<TestResponse> plantDTOS;
    private OnListItemClickListener onListItemClickListener;
    private Context context;
    public ListAdapter(Context context, List<TestResponse> plantDTOS, OnListItemClickListener onListItemClickListener) {
        this.plantDTOS = plantDTOS;
        this.context = context;
        this.onListItemClickListener = onListItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item_rv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
         viewHolder.itemInRV.setText(plantDTOS.get(position).getValue());
    }

    public void setPlants(List<TestResponse> plantDTOS){
        this.plantDTOS = plantDTOS;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return plantDTOS.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView itemInRV;
        ImageButton editPlant;
        ImageButton deletePlant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemInRV = itemView.findViewById(R.id.plant);
            context = itemView.getContext();
            editPlant = itemView.findViewById(R.id.edit_profile_pencil);
            editPlant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onListItemClickListener.onListItemEditClick(plantDTOS.get(getAdapterPosition()));
                }
            });

            deletePlant = itemView.findViewById(R.id.delete_profile_button);
            deletePlant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onListItemClickListener.onListItemDeleteCLick(plantDTOS.get(getAdapterPosition()));
                }
            });

        }
    }
}
