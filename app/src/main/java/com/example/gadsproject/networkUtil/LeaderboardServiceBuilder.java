package com.example.gadsproject.networkUtil;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaderboardServiceBuilder
{
    private static final String URL = "https://gadsapi.herokuapp.com/";

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient.build());

    private static Retrofit retrofit = builder.build();

    public static <s> s buildService(Class<s> serviceInterface)
    {
        return retrofit.create(serviceInterface);
    }
}
