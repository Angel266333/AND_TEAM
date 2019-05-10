package com.andteam.sep4greenhouse.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.network.AllPlantsCallback;
import com.andteam.sep4greenhouse.network.DeletePlantProfile;
import com.andteam.sep4greenhouse.network.ModifyPlantProfile;
import com.andteam.sep4greenhouse.network.PlantListRequest;
import com.andteam.sep4greenhouse.network.PlantRequest;
import com.andteam.sep4greenhouse.network.VoidCallback;
import com.andteam.sep4greenhouse.repository.PlantsRepository;

import java.util.LinkedList;
import java.util.List;

public class ViewPlantsViewModel extends AndroidViewModel implements AllPlantsCallback, VoidCallback {

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


    public LiveData<List<PlantDTO>> getPlants() {
        new PlantListRequest().start(this);
        return plantsLiveData;
    }

    public void editPlant(PlantDTO plantDTO) {
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).PlantID == plantDTO.PlantID) {
                plants.set(i, plantDTO);
            }
        }
        plantsLiveData.setValue(plants);
        new ModifyPlantProfile().start(plantDTO, this);
    }

    public void deletePlant(PlantDTO plantDTO) {
        new DeletePlantProfile().start(plantDTO, this);
    }

    @Override
    public void onReturn(List<PlantDTO> response) {
        plants = response;
        plantsLiveData.setValue(plants);
    }

    // Callback method for add/modify//delete request
    @Override
    public void onReturn() {
        Toast.makeText(this.getApplication(), "Changes applied!", Toast.LENGTH_LONG).show();
    }
}
