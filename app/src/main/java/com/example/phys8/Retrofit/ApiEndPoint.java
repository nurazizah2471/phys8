package com.example.phys8.Retrofit;

import com.example.phys8.Models.Categories;
import com.example.phys8.Models.Register;
import com.example.phys8.Models.TokenResponse;
import com.example.phys8.Models.User;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<Register> register(@Field("name") String name, @Field("email") String email,
                            @Field("password") String password,
                            @Field("password_confirmation") String password_confirmation);

    @POST("logout")
    Call<JsonObject> logout();

    @GET("category")
    Call<Categories> getCategory();

    @GET("myuser")
    Call<User> getUsers();
}
