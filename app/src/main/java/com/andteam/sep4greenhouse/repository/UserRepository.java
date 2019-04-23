package com.andteam.sep4greenhouse.repository;

import com.andteam.sep4greenhouse.model.LoginDTO;
import com.andteam.sep4greenhouse.model.UserProfileDTO;
import com.andteam.sep4greenhouse.network.APIConnection;

public class UserRepository {

    private static UserRepository instance;
    private UserProfileDTO userProfileDTO;
    private APIConnection apiConnection;

    private UserRepository() {
    apiConnection = new APIConnection();
    }

    public static UserRepository getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new UserRepository();
            return instance;
        }
    }

    public void login(String username, String password) {

    }

    public void update(UserProfileDTO user) {

    }
    public void delete(UserProfileDTO user) {

    }

    public UserProfileDTO getUserDetails(int userID) {
    return userProfileDTO;
    }
}
