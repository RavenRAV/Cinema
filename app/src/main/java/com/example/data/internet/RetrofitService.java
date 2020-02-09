package com.example.data.internet;

import com.example.data.entity.Movies;
import com.example.data.entity.MoviesList;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET(".")
    Call<Movies>movies(@Query("t")String title,
                           @Query("apikey")String apikey);

}
