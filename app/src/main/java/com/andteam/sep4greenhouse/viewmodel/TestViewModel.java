package com.andteam.sep4greenhouse.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;

import com.andteam.sep4greenhouse.model.TestResponse;
import com.andteam.sep4greenhouse.network.APIConnection;
import com.andteam.sep4greenhouse.network.LoginRequestCallback;

import java.util.LinkedList;
import java.util.List;

public class TestViewModel extends AndroidViewModel implements LoginRequestCallback {

    private List<TestResponse> testResponses;
    private MutableLiveData<List<TestResponse>> mutableTestResponse;


    public TestViewModel(Application application) {
        super(application);
        testResponses = new LinkedList<>();
        mutableTestResponse = new MutableLiveData<>();
        mutableTestResponse.setValue(testResponses);
    }


    public MutableLiveData<List<TestResponse>> getResponses() {
        APIConnection.login("chuck@norris.ko", "roundhousekick", this);
        return mutableTestResponse;
    }

    @Override
    public void onReturn(TestResponse response) {
        testResponses.add(response);
        mutableTestResponse.setValue(testResponses);
    }

//    public static void main(String[] args) {
//        APIConnection.login("chuck@norris.ko", "roundhousekick", new LoginRequestCallback() {
//            @Override
//            public void onReturn(TestResponse response) {
//                System.out.printf("Response %s", response);
//            }
//        });
//    }

}
