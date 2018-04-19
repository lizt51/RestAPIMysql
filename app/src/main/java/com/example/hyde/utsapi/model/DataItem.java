package com.example.hyde.utsapi.model;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("nama")
    public String nama;

    @SerializedName("no_tlp")
    public String noTlp;

    @SerializedName("id")
    public String id;

    @SerializedName("alamat")
    public String alamat;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}