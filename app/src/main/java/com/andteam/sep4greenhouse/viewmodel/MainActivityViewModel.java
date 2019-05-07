package com.andteam.sep4greenhouse.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.network.LoginRequestCallback;
import com.andteam.sep4greenhouse.repository.UserRepository;
import com.andteam.sep4greenhouse.view.MainActivity;

public class MainActivityViewModel extends ViewModel implements LoginRequestCallback {
    // Notifies the repository
    // Boolean live data if logged in or not
    private UserRepository userRepository;
    public MutableLiveData<Boolean> test;
    public String responseFromRetrofit;

    public MainActivityViewModel() {
        userRepository = new UserRepository();
        test = new MutableLiveData<>();
        test.setValue(false);
    }

    public MutableLiveData<Boolean> getTest() {
        return test;
    }

    public void editPlant() {

    }

    public void deletePlant() {

    }

    @Override
    public void onReturn(TestResponse response) {
        responseFromRetrofit = response.getValue();
        test.setValue(true);
    }
}
