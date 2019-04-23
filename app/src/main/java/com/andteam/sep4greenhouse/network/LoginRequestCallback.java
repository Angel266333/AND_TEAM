package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginResponseDTO;

interface LoginRequestCallback {

    public void onReturn(LoginResponseDTO response);

}
