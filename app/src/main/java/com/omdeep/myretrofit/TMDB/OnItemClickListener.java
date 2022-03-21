package com.omdeep.myretrofit.TMDB;

import java.util.List;

public interface OnItemClickListener {

    void onItemClick(List<PopularMovieResultsPOJO> popularMovieList, int position);
}
