package com.andteam.sep4greenhouse.model;

public class TestResponse {

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public TestResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TestResponse{" +
                "response='" + response + '\'' +
                '}';
    }

}
