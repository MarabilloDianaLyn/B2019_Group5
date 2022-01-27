package com.example.financewise;

import com.google.gson.annotations.SerializedName;

public class LogInResponseModel {

    @SerializedName("success")
    private String success;

    @SerializedName("message")
    private String message;

    @SerializedName("user_details")
    private UserDetailModel userDetailObject;

    public UserDetailModel getUserDetailObject() {
        return userDetailObject;
    }

    public String getMessage() {
        return message;
    }

    public String getSuccess() {
        return success;
    }
}
