package com.example.gadsproject.networkUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface LeaderboardService
{
    @GET("api/hours")
    Call<List<HashMap>> getTopLearners();


    @GET("api/skilliq")
    Call<List<HashMap>> getTopScorers();
}
