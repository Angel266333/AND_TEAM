package com.andteam.sep4greenhouse.model;

import java.io.Serializable;
import java.sql.Date;

public class PlantDTO implements Serializable {

    public final int PlantID;
    public final String PlantName;
    public final double Temperature;
    public final double CO2;
    public final double Humidity;
    public final double AmountOfWater;
    public final double HoursSinceWatering;
    public final int Light;
    public final Date DateTime;

    //TODO : Make data structure class to simplify the method signature
    public PlantDTO(int plantID, String plantName, double temperature, double CO2, double humidity, double amountOfWater, double hoursSinceWatering, int light, Date dateTime) {
        PlantID = plantID;
        PlantName = plantName;
        Temperature = temperature;
        this.CO2 = CO2;
        Humidity = humidity;
        AmountOfWater = amountOfWater;
        HoursSinceWatering = hoursSinceWatering;
        Light = light;
        DateTime = dateTime;
    }


}
