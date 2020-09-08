package com.example.gadsproject.recyclerviewUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsproject.R;

import java.util.HashMap;
import java.util.List;

public class LeadersRecyclerAdapter extends RecyclerView.Adapter<LeadersRecyclerViewHolder>
{
    private List<HashMap> adapterDataSource;

    public LeadersRecyclerAdapter(List<HashMap> adapterDataSource)
    {
        this.adapterDataSource = adapterDataSource;
    }

    @NonNull
    @Override
    public LeadersRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaders_viewholder, parent, false);
        return new LeadersRecyclerViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadersRecyclerViewHolder holder, int position)
    {
        holder.nameTextView.setText(adapterDataSource.get(position).get("name").toString());
        holder.hoursTextView.setText(adapterDataSource.get(position).get("hours").toString());
        holder.displayImage(adapterDataSource.get(position).get("badgeUrl").toString() + " hours of content");
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }
}
