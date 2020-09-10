package com.example.gadsproject.recyclerviewUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsproject.R;

import java.util.HashMap;
import java.util.List;

public class IqRecyclerAdapter extends RecyclerView.Adapter<IqRecyclerViewHolder>
{
    private List<HashMap> adapterDataSource;

    public IqRecyclerAdapter(List<HashMap> adapterDataSource)
    {
        this.adapterDataSource = adapterDataSource;
    }

    @NonNull
    @Override
    public IqRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaders_viewholder, parent, false);
        return new IqRecyclerViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull IqRecyclerViewHolder holder, int position)
    {
        holder.nameTextView.setText(adapterDataSource.get(position).get("name").toString());
        holder.scoreTextView.setText(adapterDataSource.get(position).get("score").toString() + " skill IQ score, " + adapterDataSource.get(position).get("country").toString());
        holder.loadImage(adapterDataSource.get(position).get("badgeUrl").toString());
    }

    @Override
    public int getItemCount()
    {
        return adapterDataSource.size();
    }
}
