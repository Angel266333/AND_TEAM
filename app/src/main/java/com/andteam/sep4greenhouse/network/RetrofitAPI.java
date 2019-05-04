package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.LoginResponseDTO;
import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.model.UserProfileDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitAPI {

    // 1
//    @POST("/login")
//    Call<TestResponse> login();//@Body LoginDTO loginDTO);
    @GET("/jokes/random")
    Call<TestResponse> login();//@Body LoginDTO loginDTO);

    // 2
    @POST("/register")
    Call<UserProfileDTO> register(@Body UserProfileDTO userProfileDTO);

    // 3
    @GET("/user/{id}")
    Call<UserProfileDTO> retrieveUserById(@Body UserProfileDTO userProfileDTO);

    // 4 - This one might not be needed
    @POST("/user")
    Call<UserProfileDTO> addUserProfile(@Body UserProfileDTO userProfileDTO);

    // 5
    @PUT("/user/{id}")
    Call<UserProfileDTO> modifyUserProfile(@Body UserProfileDTO userProfileDTO);

    // 6
    @DELETE("/user/{id}")
    Call<UserProfileDTO> deleteUserProfile(@Body UserProfileDTO userProfileDTO);

    // 7
    @GET("/plantprofile/{id}")
    Call<PlantDTO> getPlantProfileData();

    // 8
    @GET("/plantprofile")
    // What type of attribute will be used to get this specific plant?
    // Call<List<PlantDTO>> getAllPlants(@Query());

    // 9
    @POST("/plantprofile")
    Call<PlantDTO> addPlantProfile(@Body PlantDTO plantDTO);

    // 10
    @DELETE("/plantprofile/{id}")
    Call<PlantDTO> deletePlantProfile(@Body PlantDTO plantDTO);

    // 11
    @PUT("/plantprofile/{id}")
    Call<PlantDTO> modifyPlantProfile(@Body PlantDTO plantDTO);

    // 12
    @GET("/plant/{id}")
    Call<PlantDTO> getPlantStats();

    // 13
    @POST("/water/{id}")
    Call<PlantDTO> waterPlant(@Body PlantDTO plantDTO);

}
