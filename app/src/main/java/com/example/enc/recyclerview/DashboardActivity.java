package com.example.enc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.enc.recyclerview.model.DashboardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    RecyclerView dashboardRecyclerView;
    APIInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dashboardRecyclerView = findViewById(R.id.dashboardRecyclerView);
        dashboardRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        apiInterface = APIClient.getClient().create(APIInterface.class);


        Call<DashboardResponse> call1 = apiInterface.getDashboardItems();
        call1.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {

//                DashboardRecyclerAdapter dashboardRecyclerAdapter = new DashboardRecyclerAdapter(this, ICONS, itemNames);
                DashboardRecyclerAdapter dashboardRecyclerAdapter = new DashboardRecyclerAdapter(DashboardActivity.this, response.body().getItems());
                dashboardRecyclerView.setAdapter(dashboardRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
