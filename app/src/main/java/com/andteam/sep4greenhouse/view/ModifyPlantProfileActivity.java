package com.andteam.sep4greenhouse.view;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.AppComponentFactory;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.PlantDTO;

import java.io.Serializable;

import static com.andteam.sep4greenhouse.view.ViewPlantsFragment.KEY_PLANT;


public class ModifyPlantProfileActivity extends AppCompatActivity {

    private ImageButton editPlant;
    private ImageButton deletePlant;

    private EditText minRangeTemperature;
    private EditText maxRangeTemperature;
    private EditText humidityLevel;
    private EditText waterAmount;
    private EditText waterInterval;
    private Button saveInput;
    ScrollView scrollmodifplant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_modify_plant_profile);
        minRangeTemperature = findViewById(R.id.min_range_temperature);
        maxRangeTemperature = findViewById(R.id.max_range_temperature);
        humidityLevel = findViewById(R.id.humidity_level);
        waterAmount = findViewById(R.id.water_amount);
        waterInterval = findViewById(R.id.watering_interval);
        saveInput = findViewById(R.id.savebutton);
        // Listen
        scrollmodifplant= (ScrollView)findViewById(R.id.scrollmodifplant);


        // TODO : Contact viewModel

        PlantDTO plant = (PlantDTO) getIntent().getExtras().getSerializable(KEY_PLANT);





    }
}