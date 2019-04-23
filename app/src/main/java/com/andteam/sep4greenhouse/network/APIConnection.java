package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;

public class APIConnection {

    public void login(String email, String password, LoginRequestCallback loginRequestCallback) {
        LoginDTO dto = new LoginDTO(email, password);
        new LoginRequest().start(dto, loginRequestCallback);
    }

}
