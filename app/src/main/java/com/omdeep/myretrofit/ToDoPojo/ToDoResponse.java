package com.omdeep.myretrofit.ToDoPojo;

import com.google.gson.annotations.SerializedName;

public class ToDoResponse {

    @SerializedName("userId")
    private String userId;

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("completed")
    private String completed;

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompleted() {
        return completed;
    }
}
