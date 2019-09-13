package com.example.mediademo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mediademo.R;
import com.example.mediademo.adapters.MediaAdapter;
import com.example.mediademo.data.remote.ApiClient;
import com.example.mediademo.data.remote.IMediaApi;
import com.example.mediademo.model.Media;
import com.example.mediademo.model.MediaPOJO;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static com.example.mediademo.AppConstants.API_KEY;
import static com.example.mediademo.AppConstants.API_PAGE;

public class MediaActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        //Find views
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        IMediaApi apiService = ApiClient.getClient().create(IMediaApi.class);

        Call<MediaPOJO> call = apiService.getAllMedias(API_KEY, API_PAGE);
        call.enqueue(new Callback<MediaPOJO>() {
            @Override public void onResponse(Response<MediaPOJO> response, Retrofit retrofit) {
                List<Media> medias = response.body().getMedia();
                recyclerView.setAdapter(new MediaAdapter(medias, R.layout.layout_media_list,
                        getApplicationContext()));
            }

            @Override public void onFailure(Throwable t) {
                // Log error here since request failed
            }
        });

    }
}
