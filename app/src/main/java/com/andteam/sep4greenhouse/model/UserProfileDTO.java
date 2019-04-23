package com.andteam.sep4greenhouse.model;

public class UserProfileDTO {

    public final String username;
    public final String name;
    public final String email;

    public UserProfileDTO(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }
}
