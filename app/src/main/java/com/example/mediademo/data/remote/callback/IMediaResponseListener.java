package com.example.mediademo.data.remote.callback;

import com.example.mediademo.model.MediaPOJO;

public interface IMediaResponseListener {

    void onSuccess(MediaPOJO mediaPOJO);

    void onError(String message);

}
