package com.omdeep.myretrofit.TMDB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TmdbApi {

    //@GET("/3/movies/get-popular-movies")
    @GET("3/movie/76341")
    Call<List<TmdbResponseModel>> getPopularMoviesData();
}
