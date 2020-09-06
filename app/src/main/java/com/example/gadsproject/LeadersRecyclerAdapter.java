package com.example.gadsproject;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeadersRecyclerAdapter extends RecyclerView.Adapter<LeadersRecyclerViewHolder>
{
    private ArrayList<UserInfo> userInfoArrayList;

    public LeadersRecyclerAdapter(ArrayList<UserInfo> userInfoArray)
    {
        this.userInfoArrayList = userInfoArray;
    }

    @NonNull
    @Override
    public LeadersRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaders_viewholder, parent, false);
        return new LeadersRecyclerViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadersRecyclerViewHolder holder, int position)
    {
        holder.badgeImage.setImageURI(Uri.parse(userInfoArrayList.get(position).getBadgeUrl()));
        holder.nameTextView.setText(userInfoArrayList.get(position).getUserName());
        holder.detailTextView.setText(userInfoArrayList.get(position).getUserDetail());
    }

    @Override
    public int getItemCount()
    {
        return userInfoArrayList.size();
    }
}
