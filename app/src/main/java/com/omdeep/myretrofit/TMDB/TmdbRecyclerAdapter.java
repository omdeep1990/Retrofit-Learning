package com.omdeep.myretrofit.TMDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.omdeep.myretrofit.databinding.PopularMovieDisplayBinding;
import java.util.List;

public class TmdbRecyclerAdapter extends RecyclerView.Adapter<TmdbRecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<PopularMovieResultsPOJO> list;

    public TmdbRecyclerAdapter(Context context, List<PopularMovieResultsPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TmdbRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PopularMovieDisplayBinding binding = PopularMovieDisplayBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TmdbRecyclerAdapter.MyViewHolder holder, int position) {
        String imagePoster = Utility.IMAGE_BASE_URL + list.get(position).getPosterPath();
        String imageBackground = Utility.IMAGE_BASE_URL + list.get(position).getBackDropPath();
        holder.binding.tvMovieTitle.setText(list.get(position).getOriginalTitle());
        holder.binding.tvOriginalLanguage.setText("Original Language :  "+list.get(position).getOriginalLanguage());
        holder.binding.tvReleaseDate.setText("Release Date :  "+list.get(position).getReleaseDate());
        holder.binding.tvVoteCount.setText("Vote Count : "+list.get(position).getVoteCount());
        holder.binding.tvVoteAvg.setText("Vote Avg. : " + list.get(position).getVoteAverage());
        holder.binding.tvOverview.setText("Overview :"+ "\n"+ list.get(position).getOverView());
        holder.binding.tvPopularity.setText("Popularity : " + list.get(position).getPopularity());

//        //TODO: Glide use to set image
        Glide.with(context).load(imageBackground).into(holder.binding.imageViewPosterPath);
        Glide.with(context).load(imagePoster).into(holder.binding.imageViewBackdrop);

        //TODO: Picasso use to set image
//        Picasso.get().load(ima.getCategoryImageUrl()).into(holder.categoryIV);
//        Picasso.get().load(imageBackground).into(holder.binding.imageViewPosterPath);
//        Picasso.get().load(imagePoster).into(holder.binding.imageViewBackdrop);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        PopularMovieDisplayBinding binding;
        public MyViewHolder(PopularMovieDisplayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
