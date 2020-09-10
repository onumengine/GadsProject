package com.example.gadsproject.recyclerviewUtil;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gadsproject.R;

public class IqRecyclerViewHolder extends RecyclerView.ViewHolder
{
    public TextView nameTextView, scoreTextView;
    public ImageView badgeImageView;

    public IqRecyclerViewHolder(@NonNull View itemView)
    {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_textview);
        scoreTextView = itemView.findViewById(R.id.detail_textview);
        badgeImageView = itemView.findViewById(R.id.badge_image);
    }

    public void loadImage(String imageUrl)
    {
        Glide.with(itemView)
                .load(imageUrl)
                .placeholder(null)
                .into(badgeImageView);
    }
}
