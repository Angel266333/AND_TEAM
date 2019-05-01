package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginResponseDTO;
import com.andteam.sep4greenhouse.model.TestResponse;

public interface LoginRequestCallback {

    public void onReturn(TestResponse response);

}
