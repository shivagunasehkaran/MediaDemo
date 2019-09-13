package com.example.mediademo.data.remote;

import com.example.mediademo.model.MediaPOJO;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface IMediaApi {

    @GET("api/")
    Call<MediaPOJO> getAllMedias(@Query("key") String key, @Query("page") String page);
}
