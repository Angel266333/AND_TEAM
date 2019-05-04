package com.andteam.sep4greenhouse.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.network.LoginRequestCallback;
import com.andteam.sep4greenhouse.repository.UserRepository;

public class RegisterViewModel implements LoginRequestCallback {
    // Notifies the repository
    // Boolean live data if logged in or not
    private UserRepository userRepository;
    public MutableLiveData<Boolean> test;
    public String responseFromRetrofit;

    public RegisterViewModel() {
        userRepository = new UserRepository();
        test = new MutableLiveData<>();
        test.setValue(false);
    }

    public MutableLiveData<Boolean> getTest() {
        return test;
    }

    public void register(String email, String username, String name, String password) {
        userRepository.register(email, username, name, password, this);
    }

    @Override
    public void onReturn(TestResponse response) {
        responseFromRetrofit = response.getValue();
        test.setValue(true);
    }
}
