package com.andteam.sep4greenhouse.view;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.repository.UserRepository;
import com.andteam.sep4greenhouse.view.adapter.ListAdapter;
import com.andteam.sep4greenhouse.viewmodel.ViewPlantsViewModel;

import org.w3c.dom.Text;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class ViewPlantsFragment extends Fragment implements OnListItemClickListener {

    public static final int EDIT_PLANT_REQUEST = 1337;
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    // Replace with actual class that contains plant object.
    private List<PlantDTO> plants;
    private ViewPlantsViewModel viewModel;
    private Activity context;
    private TextView welcomeuser;
    public static final String KEY_PLANT = "KEY_PLANT";
    List<PlantDTO> plantDTOS = new ArrayList<>();
    public final static String KEY_USERNAME = "username";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate Layout and present it
        View v = inflater.inflate(R.layout.fragment_viewplants, container, false);

        welcomeuser =  v.findViewById(R.id.welcomeuser);
        welcomeuser.setText(UserRepository.getInstance().getEmail());

        // Initialize ViewModel
        //viewModel = ViewModelProviders.of(this).get(ViewPlantsViewModel.class);

        recyclerView = v.findViewById(R.id.rv);
        adapter = new ListAdapter(getActivity());

        plantDTOS.add(new PlantDTO(1,"Cacti", 66, 44, 44, 4, 4,4, new Date(34)));
        adapter.setPlants(plantDTOS);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
/*        viewModel.getPlants().observe(this, new Observer<List<PlantDTO>>() {
            @Override
            public void onChanged(@Nullable List<PlantDTO> plantDTOS) {
                adapter.setPlants(plantDTOS);
            }
        });*/
        return v;
    }

    @Override
    public void onListItemEditClick(TestResponse plantDTO) {
        // Replace fragment in MainActivity with EditPlantFragment
//        Fragment editPlantProfile = new ModifyPlantProfileActivity();
//        ((MainActivity) getActivity()).loadFragment(editPlantProfile);
    }

    @Override
    public void onListItemDeleteCLick(TestResponse plantDTO) {
        // Invoke viewmodel to do a delete on specific plant object

    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == EDIT_PLANT_REQUEST) {
            if (resultCode == RESULT_OK) {
                PlantDTO plantDTO = (PlantDTO) data.getExtras().getSerializable(KEY_PLANT);
                viewModel.editPlant(plantDTO);
            }
        }
    }


}