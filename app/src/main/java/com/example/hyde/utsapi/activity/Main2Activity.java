package com.example.hyde.utsapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hyde.utsapi.R;
import com.example.hyde.utsapi.adapter.PelAdapter;
import com.example.hyde.utsapi.api.ApiCall;
import com.example.hyde.utsapi.api.ApiInterface;
import com.example.hyde.utsapi.model.DataItem;
import com.example.hyde.utsapi.model.ResponseItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private PelAdapter adapter;
    private DataItem hitsItem;
    private ImageView view;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        textView = (TextView)findViewById(R.id.ksg);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Form.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        ApiInterface apiInterface = ApiCall.getClient().create(ApiInterface.class);
        Call<ResponseItem> responseCall = apiInterface.getPelanggan();


        responseCall.enqueue(new Callback<ResponseItem>() {
            @Override
            public void onResponse(Call<ResponseItem> call, Response<ResponseItem> response) {
                if (response.body().data.size() > 0) {
                    adapter = new PelAdapter(Main2Activity.this, response.body().data);
                    //
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(Main2Activity.this);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());//
                    //adapter
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseItem> call, Throwable t) {
                Log.i("autolog", "t: " + t.getMessage());
                Log.i("autolog", "t: " + t.getLocalizedMessage());
            }
        });


    }
}
