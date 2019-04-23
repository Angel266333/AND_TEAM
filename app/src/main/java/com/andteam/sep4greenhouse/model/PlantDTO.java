package com.andteam.sep4greenhouse.model;

public class PlantDTO {

    public final int pID;
    public final String temperature;
    public final String co2;
    public final String humidity;
    public final String waterAmount;
    public final String waterInterval;

    public PlantDTO(int pID, String temperature, String co2, String humidity, String waterAmount, String waterInterval) {
        this.pID = pID;
        this.temperature = temperature;
        this.co2 = co2;
        this.humidity = humidity;
        this.waterAmount = waterAmount;
        this.waterInterval = waterInterval;
    }
}
