package com.example.taufiq.pixabay.api;

import com.example.taufiq.pixabay.model.Hit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface api {


    @GET("api/")
    Call<List<Hit>> getTheData(@Query("key") String key, @Query("q") String q);

}
