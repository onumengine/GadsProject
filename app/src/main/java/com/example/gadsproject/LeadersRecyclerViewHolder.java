package com.example.gadsproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class LeadersRecyclerViewHolder extends RecyclerView.ViewHolder
{
    public ImageView badgeImage = itemView.findViewById(R.id.badge_image);
    public TextView nameTextView = itemView.findViewById(R.id.name_textview);
    public TextView detailTextView = itemView.findViewById(R.id.detail_textview);

    public LeadersRecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
    }

    public void displayImage(@NonNull String url)
    {
        Glide.with(itemView)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder_image_24)
                .error(R.drawable.ic_broken_image_24)
                .fallback(R.drawable.ic_placeholder_image_24)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(badgeImage);
    }
}
