package com.andteam.sep4greenhouse.view;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.view.adapter.ListAdapter;
import com.andteam.sep4greenhouse.viewmodel.ViewPlantsViewModel;

import java.util.List;


public class ViewPlantsFragment extends Fragment implements OnListItemClickListener {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    // Replace with actual class that contains plant object.
    private List<TestResponse> plants;
    private ViewPlantsViewModel viewModel;
    private Activity context;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context = getActivity();
        // Initialize RecyclerView
        View v = inflater.inflate(R.layout.fragment_viewplants, container, false);

        // Initialize ViewModel
        viewModel = ViewModelProviders.of(this).get(ViewPlantsViewModel.class);

        recyclerView = context.findViewById(R.id.rv);
        adapter = new ListAdapter(getContext(), viewModel);
        viewModel.getPlants().observe(this, new Observer<List<PlantDTO>>() {
            @Override
            public void onChanged(@Nullable List<PlantDTO> plantDTOS) {
                adapter.setPlants(plantDTOS);
            }
        });

        return v;
    }

    @Override
    public void onListItemEditClick(TestResponse plantDTO) {
        // Replace fragment in MainActivity with EditPlantFragment
        Fragment editPlantProfile = new ModifyPlantProfileFragment();
        ((MainActivity) getActivity()).loadFragment(editPlantProfile);
    }

    @Override
    public void onListItemDeleteCLick(TestResponse plantDTO) {
        // Invoke viewmodel to do a delete on specific plant object

    }
}