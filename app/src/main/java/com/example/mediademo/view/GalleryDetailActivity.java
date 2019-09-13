package com.example.mediademo.view;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.mediademo.R;

import java.io.InputStream;

import butterknife.BindView;

public class GalleryDetailActivity extends AppCompatActivity {

    private static final String KEY_IMAGE_URI = "image_uri";

    @BindView(R.id.imageView)
    ImageView imageView;

    String imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);

        if (getIntent().hasExtra(KEY_IMAGE_URI)) {
            imageUri = getIntent().getStringExtra(KEY_IMAGE_URI);
        }

        setUp();
    }

    private void setUp() {
        if (imageUri == null) {
            return;
        }
        // show The Image in a ImageView
        new DownloadImageTask((ImageView) findViewById(R.id.imageView))
                .execute(imageUri);
    }

    @SuppressLint("StaticFieldLeak") private class DownloadImageTask
            extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
