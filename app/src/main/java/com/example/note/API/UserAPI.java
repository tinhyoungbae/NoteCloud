package com.example.note.API;

import com.example.note.Model.News;
import com.example.note.Model.ResponseAPI;
import com.example.note.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAPI {
    Gson gson =  new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    UserAPI userAPI = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UserAPI.class);

    @GET("user/{userID}")
    Call<Boolean> getUser(@Path("userID") String userID);

    @POST("user")
    Call<Boolean> addUser(@Body User user);

    @DELETE("user/{userID}")
    Call<User> deleteUser(@Path("userID") String userID);

    @POST("user/check")
    Call<Boolean> checkUser(@Body User user);
}
