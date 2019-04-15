package com.calcounterapplicaton.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CreatePlantProfileActivity extends AppCompatActivity {
    Spinner spinner_d;
    String options[]={"Normal Templatte","Tropical Template","Desert Template"};
    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.create_plant_profile_activity);

        spinner_d=(Spinner)findViewById(R.id.spinner_drop_down);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        spinner_d.setAdapter(arrayAdapter);

        spinner_d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Your chosen template is: "+options[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
