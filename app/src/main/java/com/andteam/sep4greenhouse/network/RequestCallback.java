package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.TestResponse;

public interface RequestCallback {

    public void onReturn(TestResponse response);

}
