package com.example.enc.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DashboardActivity extends AppCompatActivity {


    private static final int[] ICONS = {R.drawable.ic_home_black_24dp, R.drawable.ic_person_outline_black_24dp,
            R.drawable.ic_settings_black_24dp, R.drawable.ic_wb_sunny_black_24dp,
            R.drawable.ic_call_black_24dp, R.drawable.ic_mail_outline_black_24dp,
            R.drawable.ic_photo_camera_black_24dp, R.drawable.ic_music_note_black_24dp,
            R.drawable.ic_volume_off_black_24dp, R.drawable.ic_settings_power_black_24dp,
            R.drawable.ic_home_black_24dp, R.drawable.ic_person_outline_black_24dp,
            R.drawable.ic_settings_black_24dp, R.drawable.ic_wb_sunny_black_24dp,
            R.drawable.ic_call_black_24dp, R.drawable.ic_mail_outline_black_24dp,
            R.drawable.ic_photo_camera_black_24dp, R.drawable.ic_music_note_black_24dp,
            R.drawable.ic_volume_off_black_24dp, R.drawable.ic_settings_power_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView dashboardRecyclerView = findViewById(R.id.dashboardRecyclerView);
        dashboardRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        String[] itemNames = getResources().getStringArray(R.array.item_names);
        DashboardRecyclerAdapter dashboardRecyclerAdapter = new DashboardRecyclerAdapter(this,
                ICONS,
                itemNames);
        dashboardRecyclerView.setAdapter(dashboardRecyclerAdapter);
    }
}
