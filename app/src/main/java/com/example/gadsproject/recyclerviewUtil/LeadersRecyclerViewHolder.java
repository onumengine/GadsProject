package com.example.gadsproject.recyclerviewUtil;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.gadsproject.R;

public class LeadersRecyclerViewHolder extends RecyclerView.ViewHolder
{
    public ImageView badgeImage;
    public TextView nameTextView;
    public TextView hoursTextView;

    public LeadersRecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textview);
        hoursTextView = itemView.findViewById(R.id.detail_textview);
        badgeImage = itemView.findViewById(R.id.badge_image);
    }

    public void displayImage(@NonNull String imageUrl)
    {
        Glide.with(itemView)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder_image_24)
                .error(R.drawable.ic_broken_image_24)
                .fallback(R.drawable.ic_placeholder_image_24)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(badgeImage);
    }
}
