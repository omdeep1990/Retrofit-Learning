package com.omdeep.myretrofit.TMDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.databinding.PopularMovieDisplayBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TmdbRecyclerAdapter extends RecyclerView.Adapter<TmdbRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<PopularMovieResultsPOJO> list;

    public TmdbRecyclerAdapter(Context context, List<TmdbResponseModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TmdbRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_movie_display, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TmdbRecyclerAdapter.MyViewHolder holder, int position) {
        PopularMovieResultsPOJO popularMovieResultsPOJO = list.get(position);
        String imagePoster = Utility.IMAGE_BASE_URL + popularMovieResultsPOJO.getPosterPath();
        String imageBackground = Utility.IMAGE_BASE_URL + popularMovieResultsPOJO.getBackDropPath();
        holder.movieTitle.setText(popularMovieResultsPOJO.getOriginalTitle());
        holder.originalLanguage.setText("Original Language :  "+popularMovieResultsPOJO.getOriginalLanguage());
        holder.releaseDate.setText("Release Date :  "+popularMovieResultsPOJO.getReleaseDate());
        holder.tvVoteCount.setText("Vote Count : "+popularMovieResultsPOJO.getVoteCount());
        holder.tvAverage.setText("Vote Avg. : " + popularMovieResultsPOJO.getVoteAverage());
        holder.overView.setText("Overview :"+ "\n"+ popularMovieResultsPOJO.getOverView());
        holder.popularity.setText("Popularity : " + popularMovieResultsPOJO.getPopularity());

//        //TODO: Glide use to set image
//        Glide.with(context).load(imageBackground).into(holder.imageViewPosterPath);
//        Glide.with(context).load(imagePoster).into(holder.movieBinding.imageViewBackdrop);

        //TODO: Picasso use to set image
//        Picasso.get().load(ima.getCategoryImageUrl()).into(holder.categoryIV);
        Picasso.get().load(imageBackground).into(holder.binding.imageViewPosterPath);
        Picasso.get().load(imagePoster).into(holder.binding.imageViewBackdrop);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterPath, backDrop;
        private TextView movieTitle, releaseDate, originalLanguage, popularity, tvAdult, tvTitle, tvVoteCount, tvAverage, overView;
        PopularMovieDisplayBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.tv_movie_title);
            releaseDate = itemView.findViewById(R.id.tv_release_date);
            originalLanguage = itemView.findViewById(R.id.tv_original_language);
            popularity = itemView.findViewById(R.id.tv_popularity);
//            tvAdult = itemView.findViewById(R.id.tv_adult);
//            tvTitle = itemView.findViewById(R.id.tv_title);
            tvVoteCount = itemView.findViewById(R.id.tv_vote_count);
            tvAverage = itemView.findViewById(R.id.tv_vote_avg);
            posterPath = itemView.findViewById(R.id.imageView_poster_path);
            backDrop = itemView.findViewById(R.id.imageView_backdrop);
            overView = itemView.findViewById(R.id.tv_overview);

        }
    }
}
