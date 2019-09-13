package com.example.mediademo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mediademo.R;
import com.example.mediademo.utils.NavigatorUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.audio)
    ImageView audio;

    @BindView(R.id.gallery)
    ImageView gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind the view using butterknife
        ButterKnife.bind(this);
    }

    @OnClick(R.id.audio)
    public void redirectToMedia(View view) {
        NavigatorUtils.goToMediaScreen(this);
    }

    @OnClick(R.id.gallery)
    public void redirectToGallery(View view) {
        NavigatorUtils.goToGalleryScreen(this);
    }
}
