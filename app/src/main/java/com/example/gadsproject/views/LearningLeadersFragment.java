package com.example.gadsproject.views;

import android.os.Bundle;

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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment
{
    public RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.learning_leaders_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    private void makeApiCall()
    {
        NetworkService networkService = ServiceBuilder.buildService(NetworkService.class);
        Call<ArrayList> call = networkService.getTopLearners();
        call.enqueue(new Callback<ArrayList>()
        {
            @Override
            public void onResponse(Call<ArrayList> call, Response<ArrayList> response)
            {
                recyclerView.setAdapter(new LeadersRecyclerAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<ArrayList> call, Throwable throwable)
            {
                Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}