package com.example.taufiq.pixabay.api;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client {


    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    private static final String BASE_URL = "https://pixabay.com/";


    private Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClientBuilder.build());

    Retrofit retrofit = builder.build();

    }

