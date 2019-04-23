package com.andteam.sep4greenhouse.repository;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.ProfileDTO;

import java.util.List;

public class PlantsRepository {

    private static PlantsRepository instance;

    public static PlantsRepository getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new PlantsRepository();
            return instance;
        }
    }

    public PlantDTO getPlantDetails(int pID) {

    }

    public List<ProfileDTO> getPlantProfile() {

    }

    public boolean createPlantProfile(String name, int waterAmount, int waterInterval) {

    }
}
