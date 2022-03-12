package com.omdeep.myretrofit.PhotoesPojo;

import com.google.gson.annotations.SerializedName;

public class PhotoesResponse {

    @SerializedName("albumId")
    private String albumId;

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("url")

    //https://via.placeholder.com/600/92c952
    private String url;

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public String getAlbumId() {
        return albumId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
