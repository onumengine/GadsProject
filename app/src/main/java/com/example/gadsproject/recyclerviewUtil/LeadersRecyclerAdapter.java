package com.example.gadsproject.recyclerviewUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeadersRecyclerAdapter extends RecyclerView.Adapter<LeadersRecyclerViewHolder>
{
    private ArrayList userInfoArrayList;

    public LeadersRecyclerAdapter(ArrayList userInfoArray)
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
        HashMap<String, String> userInfo = (HashMap<String, String>) userInfoArrayList.get(position);
        holder.nameTextView.setText(userInfo.get("name"));
        holder.detailTextView.setText(userInfo.get("hours"));
        holder.displayImage(userInfo.get("badgeUrl"));
    }

    @Override
    public int getItemCount()
    {
        return userInfoArrayList.size();
    }
}
