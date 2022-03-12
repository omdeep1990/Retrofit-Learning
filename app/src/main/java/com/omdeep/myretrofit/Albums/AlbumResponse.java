package com.omdeep.myretrofit.Albums;

import com.google.gson.annotations.SerializedName;

public class AlbumResponse {

    @SerializedName("userId")
    private String userId;

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
