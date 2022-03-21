package com.omdeep.myretrofit.TMDB;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmdbResponseModel {

@SerializedName("page")
    private int PopularMoviesPage;

    @SerializedName("results")
    private List<PopularMovieResultsPOJO> PopularMoviesResult;

    @SerializedName("total_pages")
    private int PopularMoviesTotalPages;

    @SerializedName("total_results")
    private int PopularMoviesTotalResults;

    public TmdbResponseModel(int popularMoviesPage, List<PopularMovieResultsPOJO> popularMoviesResult, int popularMoviesTotalPages, int popularMoviesTotalResults) {
        PopularMoviesPage = popularMoviesPage;
        PopularMoviesResult = popularMoviesResult;
        PopularMoviesTotalPages = popularMoviesTotalPages;
        PopularMoviesTotalResults = popularMoviesTotalResults;
    }

    public int getPopularMoviesPage() {
        return PopularMoviesPage;
    }

    public List<PopularMovieResultsPOJO> getPopularMoviesResult() {
        return PopularMoviesResult;
    }

    public int getPopularMoviesTotalPages() {
        return PopularMoviesTotalPages;
    }

    public int getPopularMoviesTotalResults() {
        return PopularMoviesTotalResults;
    }
}
