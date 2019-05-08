package com.andteam.sep4greenhouse.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.network.LoginRequestCallback;
import com.andteam.sep4greenhouse.repository.PlantsRepository;

import java.util.LinkedList;
import java.util.List;

public class ViewPlantsViewModel extends AndroidViewModel implements LoginRequestCallback {

    private PlantsRepository plantsRepository;
    private MutableLiveData<List<PlantDTO>> plantsLiveData;
    private String responseFromRetrofit;
    private List<PlantDTO> plants;

    public ViewPlantsViewModel(Application application) {
        super(application);
        plantsRepository = new PlantsRepository();
        plants = new LinkedList<>();
        plantsLiveData = new MutableLiveData<>();
        plantsLiveData.setValue(plants);
    }


    public MutableLiveData<List<PlantDTO>> getPlants() {
        //TODO make api call for plants
        return plantsLiveData;
    }

    public void editPlant(PlantDTO plantDTO) {
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).PlantID == plantDTO.PlantID) {
                plants.set(i, plantDTO);
            }
        }
        plantsLiveData.setValue(plants);
        //edit in repo, so make update request
    }

    public void deletePlant(PlantDTO plantDTO) {

    }

    @Override
    public void onReturn(TestResponse response) {

        //TODO Update l
        responseFromRetrofit = response.getValue();
        //test.setValue(true);
    }

}
