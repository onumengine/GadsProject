package com.example.gadsproject.networkUtil;

import com.example.gadsproject.models.UserInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService
{
    @GET("/api/hours")
    Call<ArrayList<UserInfo>> getTopLearners();

    @GET("/api/skilliq")
    Call<ArrayList<UserInfo>> getTopScorers();
}
