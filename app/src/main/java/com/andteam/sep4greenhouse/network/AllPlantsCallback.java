package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.PlantDTO;

import java.util.List;

public interface AllPlantsCallback {

    public void onReturn(List<PlantDTO> response);

}
