package com.example.data.internet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static RetrofitService retrofitService;

    public static RetrofitService getRetrofitService(){
        if(retrofitService == null)
            retrofitService = buildRetrofit();


        return retrofitService;
    }

    private static RetrofitService buildRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);
    }
}
