package com.example.hyde.utsapi.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hyde.utsapi.R;
import com.example.hyde.utsapi.api.ApiCall;
import com.example.hyde.utsapi.api.ApiInterface;
import com.example.hyde.utsapi.model.DataItem;
import com.example.hyde.utsapi.model.ResponseItem;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormEdit extends AppCompatActivity {

    EditText nam, almt, tlp;
    Button btl, smpn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit);

        nam = (EditText) findViewById(R.id.enama);
        almt = (EditText) findViewById(R.id.ealam);
        tlp = (EditText) findViewById(R.id.enmr);

        btl = (Button) findViewById(R.id.batal);
        smpn = (Button) findViewById(R.id.simpan);

        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormEdit.this.finish();
            }
        });

        smpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //membuat dialog progres
                final ProgressDialog progress = new ProgressDialog(FormEdit.this);
                progress.setCancelable(false);
                progress.setMessage("Loading ...");
                progress.show();

               /* String nama = nam.getText().toString();
                String alamat = almt.getText().toString();
                String no_tlp = tlp.getText().toString();*/

                DataItem dataItem = new DataItem();
                dataItem.setNama(nam.getText().toString());
                dataItem.setAlamat(almt.getText().toString());
                dataItem.setNoTlp(tlp.getText().toString());
                String json = new Gson().toJson(dataItem);

                int id = 8;
                ApiInterface apiInterface = ApiCall.getClient().create(ApiInterface.class);
                Call<ResponseItem> call = apiInterface.ubah("application/x-www-form-urlencoded", json);

                call.enqueue(new Callback<ResponseItem>() {
                    @Override
                    public void onResponse(Call<ResponseItem> call, Response<ResponseItem> response) {
                        String json = new Gson().toJson(response);
                        Log.i("autolog", "t: " + json);
                        progress.dismiss();
                        FormEdit.this.finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseItem> call, Throwable t) {
                        Log.i("autolog", "t: " + t.getMessage());
                        Log.i("autolog", "t: " + t.getLocalizedMessage());
                    }
                });

            }
        });
    }
}
