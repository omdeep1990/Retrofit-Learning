package com.omdeep.myretrofit;

import java.util.List;

import com.omdeep.myretrofit.PostsPojo.PostsResponse;

public interface OnItemClickListner {
    void onItemClick(List<PostsResponse> postsResponseList, int position);
}
