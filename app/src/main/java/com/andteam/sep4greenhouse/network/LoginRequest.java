package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.LoginResponseDTO;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<LoginResponseDTO> call = api.login(loginDTO);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {
        if (response.code() == 200) {
            callback.onReturn(response.body());
        } else {
            callback.onReturn(new LoginResponseDTO(false, null));
        }
    }

    @Override
    public void onFailure(Call<LoginResponseDTO> call, Throwable t) {
        callback.onReturn(new LoginResponseDTO(false, null));
    }
}
