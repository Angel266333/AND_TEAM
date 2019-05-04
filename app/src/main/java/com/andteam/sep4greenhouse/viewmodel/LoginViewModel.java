package com.andteam.sep4greenhouse.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.network.LoginRequestCallback;
import com.andteam.sep4greenhouse.repository.UserRepository;
public class LoginViewModel extends AndroidViewModel implements LoginRequestCallback {
    // Notifies the repository
    // Boolean live data if logged in or not
    private UserRepository userRepository;
    public MutableLiveData<Boolean> test;
    public String responseFromRetrofit;

    public LoginViewModel(Application application) {
        super(application);
        userRepository = new UserRepository();
        test = new MutableLiveData<>();
        test.setValue(false);
    }

    public MutableLiveData<Boolean> getTest() {
        return test;
    }

    public void login(String email, String password) {
        userRepository.login(email, password, this);
    }

    @Override
    public void onReturn(TestResponse response) {
        responseFromRetrofit = response.getValue();
        test.setValue(true);
    }
}
