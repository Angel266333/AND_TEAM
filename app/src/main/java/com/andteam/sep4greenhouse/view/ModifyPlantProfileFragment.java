package com.andteam.sep4greenhouse.view;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.andteam.sep4greenhouse.R;


public class ModifyPlantProfileFragment extends Fragment {

    private ImageButton editPlant;
    private ImageButton deletePlant;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String strtext = getArguments().getString("plantID");
        // TODO : Contact viewModel
        return inflater.inflate(R.layout.fragment_modify_plant_profile, null);
    }
}