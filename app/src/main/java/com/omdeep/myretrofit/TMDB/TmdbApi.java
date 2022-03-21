package com.omdeep.myretrofit.TMDB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {

    //@GET("/3/movies/get-popular-movies")
    @GET("3/movie/popular")
    Call<List<TmdbResponseModel>> getPopularMoviesData(@Query("api_key") String apiKey);

}
