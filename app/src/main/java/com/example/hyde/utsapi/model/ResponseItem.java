package com.example.hyde.utsapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseItem {

	@SerializedName("data")
	public List<DataItem> data;

	@SerializedName("status")
	public boolean status;
}