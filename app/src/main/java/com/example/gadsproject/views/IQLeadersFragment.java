package com.example.gadsproject.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsproject.R;
import com.example.gadsproject.networkUtil.LeaderboardService;
import com.example.gadsproject.networkUtil.LeaderboardServiceBuilder;
import com.example.gadsproject.recyclerviewUtil.IqRecyclerAdapter;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IQLeadersFragment extends Fragment
{
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_iq_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        recyclerView = view.findViewById(R.id.iq_leaders_recyclerview);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        sendHttpRequest();
    }

    private void sendHttpRequest()
    {
        LeaderboardService leaderboardService = LeaderboardServiceBuilder.buildService(LeaderboardService.class);
        Call<List<HashMap>> call = leaderboardService.getTopScorers();

        call.enqueue(new Callback<List<HashMap>>()
        {
            @Override
            public void onResponse(Call<List<HashMap>> call, Response<List<HashMap>> response)
            {
                recyclerView.setAdapter(new IqRecyclerAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<HashMap>> call, Throwable t)
            {

            }
        });
    }
}