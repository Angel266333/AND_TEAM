package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.LoginResponseDTO;
import com.andteam.sep4greenhouse.model.UserProfileDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @POST("/login")
    Call<LoginResponseDTO> login(@Body LoginDTO loginDTO);

    @POST("/register")
    Call<UserProfileDTO> register(@Body UserProfileDTO userProfileDTO);

    //@GET("/user/{id}")
    //Call<UserProfileDTO> retrieveUserById(@Body )


}
