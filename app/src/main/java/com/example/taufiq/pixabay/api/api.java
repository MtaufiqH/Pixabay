package com.example.taufiq.pixabay.api;

import com.example.taufiq.pixabay.model.Hit;
import com.example.taufiq.pixabay.model.Pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface api {


    @GET("api")
    Call<Pojo> getTheData(@Query("key") String key, @Query("q") String q);

}