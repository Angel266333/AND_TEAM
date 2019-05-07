package com.andteam.sep4greenhouse.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.viewmodel.TestViewModel;

import java.util.List;


public class ViewPlantsFragment extends Fragment implements OnListItemClickListener {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    // Replace with actual class that contains plant object.
    private List<TestResponse> plants;
    private TestViewModel viewModel;
    /*
    // Initialize RecyclerView
    recyclerView = findViewById(R.id.rv);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new ListAdapter(plants);
    //recyclerView.setAdapter(adapter);
    // Observes changes happening on Live Data
        viewModel.getResponses().observe(this, new Observer<List<TestResponse>>() {
        @Override
        public void onChanged(@Nullable List<TestResponse> testResponses) {
            adapter.setPlants(testResponses);
        }
    });
     */


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Initialize RecyclerView
        View v = inflater.inflate(R.layout.fragment_viewplants, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv);
        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new ListAdapter(getContext(), plants, this);
        recyclerView.setAdapter(adapter);
        // Observes changes happening on Live Data
        viewModel.getResponses().observe(this, new Observer<List<TestResponse>>() {
            @Override
            public void onChanged(@Nullable List<TestResponse> testResponses) {
                adapter.setPlants(testResponses);
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