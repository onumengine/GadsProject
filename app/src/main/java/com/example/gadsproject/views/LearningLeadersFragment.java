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
import android.widget.Toast;

import com.example.gadsproject.R;
import com.example.gadsproject.recyclerviewUtil.LeadersRecyclerAdapter;
import com.example.gadsproject.networkUtil.NetworkService;
import com.example.gadsproject.networkUtil.ServiceBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment
{
    public RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        makeApiCall();
    }

    private void makeApiCall()
    {
        NetworkService networkService = ServiceBuilder.buildService(NetworkService.class);
        Call<List<HashMap>> call = networkService.getTopLearners();

        call.enqueue(new Callback<List<HashMap>>()
        {
            @Override
            public void onResponse(Call<List<HashMap>> call, Response<List<HashMap>> response)
            {
                recyclerView.setAdapter(new LeadersRecyclerAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<HashMap>> call, Throwable throwable)
            {
                Toast.makeText(getContext(), throwable.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}