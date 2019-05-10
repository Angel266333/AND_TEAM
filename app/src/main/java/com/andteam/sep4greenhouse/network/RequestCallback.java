package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

import retrofit2.Callback;

public interface RequestCallback {

    public void onReturn(PlantDTO response);

}
