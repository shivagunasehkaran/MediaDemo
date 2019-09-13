package com.example.mediademo.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.mediademo.view.GalleryActivity;
import com.example.mediademo.view.MediaActivity;

public class NavigatorUtils {

    public static void goToMediaScreen(Activity activity) {
        Intent intent = new Intent(activity, MediaActivity.class);
        activity.startActivityForResult(intent, 200);
    }

    public static void goToGalleryScreen(Activity activity) {
        Intent intent = new Intent(activity, GalleryActivity.class);
        activity.startActivityForResult(intent, 200);
    }
}
