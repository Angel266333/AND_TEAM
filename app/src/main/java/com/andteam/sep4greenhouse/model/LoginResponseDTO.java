package com.andteam.sep4greenhouse.model;

public class LoginResponseDTO {
private final boolean status;
private final UserProfileDTO userProfileDTO;

    public LoginResponseDTO(boolean status, UserProfileDTO userProfileDTO) {
        this.status = status;
        this.userProfileDTO = userProfileDTO;
    }
}
