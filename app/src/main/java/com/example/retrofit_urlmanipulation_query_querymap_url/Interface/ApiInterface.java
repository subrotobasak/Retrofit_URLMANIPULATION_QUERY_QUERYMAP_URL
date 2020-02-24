package com.example.retrofit_urlmanipulation_query_querymap_url.Interface;

import com.example.retrofit_urlmanipulation_query_querymap_url.Model.Model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    //Use simple @Query
//    @GET("posts")
//    Call<List<Model>> getAllData(@Query("userId") int userId);

//    //Use @Query Advance
//    @GET("posts")
//    Call<List<Model>> getAllData(
//            @Query("userId") Integer[] userId,
//            @Query("_sort") String sort,
//            @Query("_order") String order
//    );

    //Use @QueryMap
    @GET("posts")
    Call<List<Model>> getAllData(@QueryMap Map<String, String> parameters);
}
