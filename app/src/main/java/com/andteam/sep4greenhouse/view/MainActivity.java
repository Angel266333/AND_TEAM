package com.andteam.sep4greenhouse.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.andteam.sep4greenhouse.R;
import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.viewmodel.TestViewModel;

import java.util.ArrayList;
import java.util.List;

//implement the interface OnNavigationItemSelectedListener in your activity class
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    // Replace with actual class that contains plant object.
    private List<TestResponse> plants;
    private TestViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        plants = new ArrayList<>();

        // Loading the default fragment
        //loadFragment(new ViewPlantsFragment());

        // Getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(plants);
        recyclerView.setAdapter(adapter);
        // Observes changes happening on Live Data
        viewModel.getResponses().observe(this, new Observer<List<TestResponse>>() {
            @Override
            public void onChanged(@Nullable List<TestResponse> testResponses) {
                adapter.setPlants(testResponses);
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_add_plant:
                fragment = new AddPlantFragment();
                break;

            case R.id.navigation_recycler_plants:
                fragment = new ViewPlantsFragment();
                break;

            case R.id.navigation_user_profile:
                fragment = new ModifyAccountFragment();
                break;

        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}