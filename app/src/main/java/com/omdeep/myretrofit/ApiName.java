package com.omdeep.myretrofit;

import com.omdeep.myretrofit.Albums.AlbumResponse;
import com.omdeep.myretrofit.CommentPojo.CommentResponse;
import com.omdeep.myretrofit.PhotoesPojo.PhotoesResponse;
import com.omdeep.myretrofit.PostsPojo.PostsResponse;
import com.omdeep.myretrofit.ToDoPojo.ToDoResponse;
import com.omdeep.myretrofit.UserPojo.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiName {
    @GET("/posts")
    Call<List<PostsResponse>> getPostsData();

    @GET("/comments")
    Call<List<CommentResponse>> getCommentsData();

    @GET("/users")
    Call<List<UsersResponse>> getUsersData();

    @GET("/todos")
    Call<List<ToDoResponse>> getToDoData();

    @GET("/albums")
    Call<List<AlbumResponse>> getAlbumData();

    @GET("/photos")
    Call<List<PhotoesResponse>> getPhotoData();
}
