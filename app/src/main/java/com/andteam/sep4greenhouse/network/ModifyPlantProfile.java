package com.andteam.sep4greenhouse.network;

import android.util.Log;

import com.andteam.sep4greenhouse.model.PlantDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.andteam.sep4greenhouse.network.NetworkConfig.BASE_URL;

public class ModifyPlantProfile implements Callback<Void> {

    private VoidCallback callback;

    public void start(PlantDTO plant, VoidCallback requestCallback) {
        this.callback = requestCallback;

        // Build Retrofit Connection
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Reference to RetrofitAPI class
        RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<Void> call = api.modifyPlantProfile(plant);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        if (response.code() == 200) {
            callback.onReturn();
        } else {
            callback.onReturn();
        }
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        Log.d("Login failed", t.toString());
    }
}
