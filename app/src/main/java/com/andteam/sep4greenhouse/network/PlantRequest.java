package com.andteam.sep4greenhouse.network;

import android.util.Log;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.andteam.sep4greenhouse.network.NetworkConfig.BASE_URL;

public class PlantRequest implements Callback<PlantDTO> {

    private RequestCallback callback;

    public void start(int id, RequestCallback requestCallback) {
        this.callback = requestCallback;

        // Build Retrofit Connection
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Reference to RetrofitAPI class
        RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<PlantDTO> call = api.getPlantProfileData(id);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<PlantDTO> call, Response<PlantDTO> response) {
        if (response.code() == 200) {
            callback.onReturn(response.body());
        } else {
            callback.onReturn(response.body());
        }
    }

    @Override
    public void onFailure(Call<PlantDTO> call, Throwable t) {
        Log.d("Login failed", t.toString());
    }
}
