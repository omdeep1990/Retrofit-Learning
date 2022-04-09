package com.omdeep.myretrofit.TMDB;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApi {

    @GET("3/movie/popular?")
    Call<TmdbResponseModel> getPopularMoviesData(@Query("api_key") String apiKey);

    @GET("/3/person/popular")
    Call<PopularPersonResponse> getPopularPerson(@Query("api_key") String apikey);

}
