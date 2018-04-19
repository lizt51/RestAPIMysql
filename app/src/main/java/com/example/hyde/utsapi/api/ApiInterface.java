package com.example.hyde.utsapi.api;

import com.example.hyde.utsapi.model.DataItem;
import com.example.hyde.utsapi.model.ResponseItem;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by hyde on 22/03/2018.
 */

public interface ApiInterface {
    // Memanggil API
    @GET("pelanggan")
    Call<ResponseItem> getPelanggan();

    //Memanggil API dengan Parameternya
    @FormUrlEncoded
    @PUT("pelanggan")
    Call<ResponseItem> ubah(@Header("Content-Type") String contentdata, @Field("data") String id);

    @FormUrlEncoded
    @POST("pelanggan")
    Call<ResponseItem> tambah(@Header("Content-Type") String content, @Field("nama") String nama, @Field("alamat") String alamat, @Field("no_tlp") String nomer);

    @FormUrlEncoded
    @POST("pelanggan")
    Call<ResponseItem> tambahJson(@Header("Content-Type") String content, @Field("data") String data);


    @DELETE("pelanggan")
    Call<DataItem> delet(@Query("id") String query);
}
