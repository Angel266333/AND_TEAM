package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.UserProfileDTO;

public class APIConnection {

    public void login(String email, String password, LoginRequestCallback loginRequestCallback) {
        LoginDTO dtoLogin = new LoginDTO(email, password);
        new LoginRequest().start(dtoLogin, loginRequestCallback);
    }

    public void register(String email, String username, String name) {
        UserProfileDTO dtoUser = new UserProfileDTO(email, username, name);
    }
}
