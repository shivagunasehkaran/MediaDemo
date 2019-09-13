package com.example.mediademo.model;

import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("largeImageURL") private String largeImageURL;

    @SerializedName("user") private String user;

    public Media(String largeImageURL, String user) {
        this.largeImageURL = largeImageURL;
        this.user = user;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
