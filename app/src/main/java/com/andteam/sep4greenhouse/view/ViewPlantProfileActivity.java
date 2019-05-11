package com.andteam.sep4greenhouse.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andteam.sep4greenhouse.R;

public class ViewPlantProfileActivity extends AppCompatActivity {

    private TextView readOnlyPlantName;
    private TextView readOnlyCurrentTemperature;
    private TextView readOnlyHumidityLevel;
    private TextView readOnlyCO2Level;
    Button waterPlantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_plant_profile_activity);
        readOnlyPlantName = findViewById(R.id.read_only_plant_name_text_id);
        readOnlyCurrentTemperature = findViewById(R.id.read_only_plant_name_text_id);
        readOnlyHumidityLevel= findViewById(R.id.read_only_humidity_level_text_id);
        readOnlyCO2Level= findViewById(R.id.read_only_co2_level_text_id);
    }

    public void waterPlantButton(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void displayToastMsg(View v) {

        waterPlantButton("Your plant is getting watered now!");

    }
}
