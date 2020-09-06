package com.example.gadsproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeadersRecyclerViewHolder extends RecyclerView.ViewHolder
{
    public ImageView badgeImage = itemView.findViewById(R.id.badge_image);
    public TextView nameTextView = itemView.findViewById(R.id.name_textview);
    public TextView detailTextView = itemView.findViewById(R.id.detail_textview);

    public LeadersRecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
    }
}
