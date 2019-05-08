package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RetrofitAPI {

    // 1
//    @POST("/login")
//    Call<TestResponse> login();//@Body LoginDTO loginDTO);
    @GET("/jokes/random")
    Call<TestResponse> login();//@Body LoginDTO loginDTO);

    // 2
    @GET("/plantprofile/{id}")
    Call<PlantDTO> getPlantProfileData();

    // 3
    @GET("/plantprofile")
    // What type of attribute will be used to get this specific plant?
    // Call<List<PlantDTO>> getAllPlants(@Query());

    // 4
    @POST("/plantprofile")
    Call<PlantDTO> addPlantProfile(@Body PlantDTO plantDTO);

    // 5
    @DELETE("/plantprofile/{id}")
    Call<PlantDTO> deletePlantProfile(@Body PlantDTO plantDTO);

    // 6
    @PUT("/plantprofile/{id}")
    Call<PlantDTO> modifyPlantProfile(@Body PlantDTO plantDTO);

    // 7
    @GET("/plant/{id}")
    Call<PlantDTO> getPlantStats();

    // 8
    @POST("/water/{id}")
    Call<PlantDTO> waterPlant(@Body PlantDTO plantDTO);

}
