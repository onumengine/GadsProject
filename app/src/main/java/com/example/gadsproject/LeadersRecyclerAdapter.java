package com.example.gadsproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LeadersRecyclerAdapter extends RecyclerView.Adapter<LeadersRecyclerViewHolder>
{
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

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }
}
