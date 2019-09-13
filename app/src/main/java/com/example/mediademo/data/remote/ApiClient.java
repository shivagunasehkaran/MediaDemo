package com.example.mediademo.data.remote;

import com.example.mediademo.AppConstants;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
