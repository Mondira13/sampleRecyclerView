package com.example.enc.recyclerview;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enc.recyclerview.model.DashboardResponse;
import com.example.enc.recyclerview.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class DashboardRecyclerAdapter extends RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardAdapterViewHolder> {


    private final Context context;
    private final List<Item> items;

    public DashboardRecyclerAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public DashboardAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater layoutInflater = ((DashboardActivity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.recycle_layout, viewGroup, false);
        return new DashboardAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapterViewHolder dashboardAdapterViewHolder, int i) {

        String title = items.get(i).getName();
        String images = items.get(i).getImage();
        dashboardAdapterViewHolder.itemName.setText(title);
        Picasso.get().load(images).into(dashboardAdapterViewHolder.itemIcon); // use picasso image library

    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    class DashboardAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView itemIcon;
        TextView itemName;

        public DashboardAdapterViewHolder(View itemView) {
            super(itemView);
            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemName = itemView.findViewById(R.id.itemName);
        }

    }
}
