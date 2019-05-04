package com.andteam.sep4greenhouse.model;

public class TestResponse {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TestResponse(String response) {
        this.value = response;
    }

    @Override
    public String toString() {
        return "TestResponse{" +
                "value='" + value + '\'' +
                '}';
    }
}
