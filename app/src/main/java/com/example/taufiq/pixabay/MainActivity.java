package com.example.taufiq.pixabay;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.taufiq.pixabay.adapter.MainAdapter;
import com.example.taufiq.pixabay.api.Api_Client;
import com.example.taufiq.pixabay.api.api;
import com.example.taufiq.pixabay.model.Hit;
import com.example.taufiq.pixabay.model.Pojo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainAdapter.onItemClickListener {

    private static final String TAG = "MainActivity";

    private List<Hit> list = new ArrayList<>();
    private api mApi;
    private RecyclerView recyclerView;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        initAdapter();
        init_api();


    }


    private void init_api() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(logging);
        }

        final String BASE_URL ="https://pixabay.com/";

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build());

        Retrofit retrofit = builder.build();
        mApi = retrofit.create(api.class);
        Call<Pojo> mdata = mApi.getTheData(BuildConfig.PIXABAY_API,"Kittens");
        mdata.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(@NonNull Call<Pojo> call, @NonNull Response<Pojo> response) {
                assert response.body() != null;
                list.addAll(response.body().getmHits());
                adapter.notifyDataSetChanged();
                Log.d(TAG, "onResponse: response code is " + response.code());
            }

            @Override
            public void onFailure(@NonNull Call<Pojo> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: error" + t);
            }
        });
    }

    private void initAdapter() {
        adapter = new MainAdapter(list, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(Hit item) {

    }
}
