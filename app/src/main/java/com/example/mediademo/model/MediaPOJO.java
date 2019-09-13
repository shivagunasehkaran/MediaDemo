package com.example.mediademo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MediaPOJO {

    @SerializedName("hits") private ArrayList<Media> media;

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

}
