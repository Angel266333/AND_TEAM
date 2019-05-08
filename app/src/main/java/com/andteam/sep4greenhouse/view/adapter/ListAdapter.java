package com.andteam.sep4greenhouse.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.viewmodel.ViewPlantsViewModel;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<PlantDTO> plantDTOS;
    private Context context;
    private ViewPlantsViewModel viewModel;

    public ListAdapter(Context context, ViewPlantsViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
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
        viewHolder.itemInRV.setText(plantDTOS.get(position).PlantName);
    }

    public void setPlants(List<PlantDTO> plantDTOS) {
        this.plantDTOS = plantDTOS;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return plantDTOS.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemInRV;
        ImageButton editPlant;
        ImageButton deletePlant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemInRV = itemView.findViewById(R.id.plant);
            editPlant = itemView.findViewById(R.id.edit_profile_pencil);
            deletePlant = itemView.findViewById(R.id.delete_profile_button);

            editPlant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // launch activity for result to get edited plant
                    // and then pass it to view model

                    viewModel.editPlant(plantDTOS.get(getAdapterPosition()));
                }
            });

            deletePlant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.deletePlant(plantDTOS.get(getAdapterPosition()));
                }
            });
        }
    }
}
