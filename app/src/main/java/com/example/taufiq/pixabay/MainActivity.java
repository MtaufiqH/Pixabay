package com.example.taufiq.pixabay;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        init_api();
        initAdapter();


    }


    private void init_api() {

        mApi = Api_Client.getRetrofitInstance().create(api.class);
        final Call<List<Hit>> data = mApi.getTheData(BuildConfig.PIXABAY_API,"quotes");
        data.enqueue(new Callback<List<Hit>>() {
            @Override
            public void onResponse(Call<List<Hit>> call, Response<List<Hit>> response) {
                if (response != null) {
                    list.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    Log.d(TAG, "onResponse: Code = " + response.code());
                } else {
                    Log.d(TAG, "onResponse: Code = error try again!");
                }
            }

            @Override
            public void onFailure(Call<List<Hit>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private void initAdapter() {
        adapter = new MainAdapter(list, this);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(Hit item) {

    }
}
