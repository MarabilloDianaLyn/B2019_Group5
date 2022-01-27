package com.example.financewise;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("fullname")
    private String fullname;

    @SerializedName("contactno")
    private String contactno;

    @SerializedName("email")
    private String email;

    public String getFullname() {
        return fullname;
    }

    public String getContactno() {
        return contactno;
    }

    public String getEmail() {
        return email;
    }
}
