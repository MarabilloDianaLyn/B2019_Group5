package com.example.financewise;

import com.google.gson.annotations.SerializedName;

public class RegisterResponseModel {
    @SerializedName("success")
    private String success;

    @SerializedName("message")
    private String message;

    public String getSuccess(){
        return success;
    }

    public String getMessage() {
        return message;
    }
}
