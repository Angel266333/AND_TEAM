package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.PlantDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {

    // 0 for testing
    @GET("/jokes/random")
    Call<TestResponse> login();//@Body LoginDTO loginDTO);

    // 1
    @GET("/plantprofile/{id}")
    Call<PlantDTO> getPlantProfileData(@Path("id") int id);

    // 2
    @GET("/plantprofile")
    Call<List<PlantDTO>> getAllPlants();

    // 3
    @POST("/plantprofile")
    Call<Void> addPlantProfile(@Body PlantDTO plantDTO);

    // 4
    @DELETE("/plantprofile/{id}")
    Call<Void> deletePlantProfile(@Body PlantDTO plantDTO);

    // 5
    @PUT("/plantprofile/{id}")
    Call<Void> modifyPlantProfile(@Body PlantDTO plantDTO);

    // 6
    @POST("/water/{id}")
    Call<PlantDTO> waterPlant(@Body PlantDTO plantDTO);

}
