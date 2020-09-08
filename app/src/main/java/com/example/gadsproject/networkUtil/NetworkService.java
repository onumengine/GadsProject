package com.example.gadsproject.networkUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface NetworkService
{
    @GET("api/hours")
    Call<ArrayList> getTopLearners();


    @GET("api/skilliq")
    Call<List<HashMap>> getTopScorers();
}
