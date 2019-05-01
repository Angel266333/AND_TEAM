package com.andteam.sep4greenhouse.network;

import android.util.Log;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.LoginResponseDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.andteam.sep4greenhouse.network.NetworkConfig.BASE_URL;

public class LoginRequest implements LoginCallback {

    private LoginRequestCallback callback;

    @Override
    public void start(LoginDTO loginDTO, LoginRequestCallback loginRequestCallback) {
        this.callback = loginRequestCallback;

        // Build Retrofit Connection
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Reference to RetrofitAPI class
        RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<TestResponse> call = api.login(loginDTO);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<TestResponse> call, Response<TestResponse> response) {
        if (response.code() == 200) {
            callback.onReturn(response.body());
        } else {
            callback.onReturn(response.body());
        }

    }

    @Override
    public void onFailure(Call<TestResponse> call, Throwable t) {
        Log.d("Login failed", t.toString());
    }
}
