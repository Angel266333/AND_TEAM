package com.calcounterapplicaton.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_add_plant:
                    Intent intent_create_plant = new Intent(MainActivity.this, CreatePlantProfileActivity.class);
                    startActivity(intent_create_plant);
                    return true;
                case R.id.navigation_recycler_plants:
                    Intent intent_plant_recycler = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent_plant_recycler);
                    return true;
                case R.id.navigation_user_profile:
                    Intent intent_user_proifle = new Intent(MainActivity.this, ModifyAccountActivity.class);
                    startActivity(intent_user_proifle);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
