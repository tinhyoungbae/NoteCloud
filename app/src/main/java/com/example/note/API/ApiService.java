package com.example.note.API;

import com.example.note.Model.News;
import com.example.note.Model.ResponseAPI;
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

public interface ApiService {
    Gson gson =  new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("news/{newsID}")
    Call<ResponseAPI> getNews (@Path("newsID") int newsID);

    @GET("news")
    Call<List<News>> getNewsList();

    @POST("news")
    Call<News> addNews(@Body News news);

    @DELETE("news/{newsID}")
    Call<News> deleteNews(@Path("newsID") int newsID);
}
