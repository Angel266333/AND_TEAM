package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.LoginResponseDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

import retrofit2.Callback;

public interface LoginCallback extends Callback<TestResponse> {

    void start(LoginDTO loginDTO, LoginRequestCallback loginRequestCallback);


}
