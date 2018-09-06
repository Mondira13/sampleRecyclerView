package com.example.enc.recyclerview;


import com.example.enc.recyclerview.model.DashboardResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/bins/17al1w")
    Call<DashboardResponse> getDashboardItems();

}
