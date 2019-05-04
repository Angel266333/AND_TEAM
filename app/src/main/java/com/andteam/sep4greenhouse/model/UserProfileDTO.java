package com.andteam.sep4greenhouse.model;

public class UserProfileDTO {

    public final String email;
    public final String username;
    public final String name;
    public final String password;
    public UserProfileDTO(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
