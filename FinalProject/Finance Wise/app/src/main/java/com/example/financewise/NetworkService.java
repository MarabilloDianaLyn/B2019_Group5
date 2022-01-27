package com.example.financewise;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NetworkService {
    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponseModel> fw_register (@FieldMap HashMap<String, String> params);

    @FormUrlEncoded
    @POST("login.php")
    Call<LogInResponseModel> login(@Field("email") String email, @Field("password") String pasword);
}
