package com.andteam.sep4greenhouse.network;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.UserProfileDTO;

public class APIConnection {

    public static void login(String email, String password, LoginRequestCallback loginRequestCallback) {
        LoginDTO dtoLogin = new LoginDTO(email, password);
        new LoginRequest().start(dtoLogin, loginRequestCallback);
    }

    public static void register(String email, String username, String name, String password) {
        UserProfileDTO dtoUser = new UserProfileDTO(email, username, name, password);
    }
}
