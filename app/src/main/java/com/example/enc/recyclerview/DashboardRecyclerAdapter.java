package com.example.enc.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DashboardRecyclerAdapter extends RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardAdapterViewHolder> {

    String[] itemNames;
    int[] ICONS;
    Context context;

    public DashboardRecyclerAdapter(Context context, int[] ICONS, String[] itemNames) {
        this.context = context;
        this.ICONS = ICONS;
        this.itemNames = itemNames;


    }

    @NonNull
    @Override
    public DashboardAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater layoutInflater = ((DashboardActivity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.recycle_layout,viewGroup,false);
        return new DashboardAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapterViewHolder dashboardAdapterViewHolder, int i) {

        String title = itemNames[i];
        int images = ICONS[i];
        dashboardAdapterViewHolder.itemName.setText(title);
        dashboardAdapterViewHolder.itemIcon.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return itemNames.length;
    }


    class DashboardAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView itemIcon;
        TextView itemName;
        public DashboardAdapterViewHolder(View itemView){
            super(itemView);
            itemIcon = itemView.findViewById(R.id.itemIcon);
            itemName = itemView.findViewById(R.id.itemName);
        }

    }
}
