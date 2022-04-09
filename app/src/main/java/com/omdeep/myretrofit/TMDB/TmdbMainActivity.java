package com.omdeep.myretrofit.TMDB;

import static com.omdeep.myretrofit.TMDB.Utility.showLongToast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.omdeep.myretrofit.databinding.ActivityTmdbMainBinding;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TmdbMainActivity extends AppCompatActivity {
    ActivityTmdbMainBinding binding;
    TmdbRecyclerAdapter tmdbRecyclerAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTmdbMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerViewFromMainActivity.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        TmdbApi apiName = TmdbRetrofitApi.getInstance(TmdbApi.class);
        Call<TmdbResponseModel> call = apiName.getPopularMoviesData(Utility.KEY);
        call.enqueue(new Callback<TmdbResponseModel>() {
            @Override
            public void onResponse(Call<TmdbResponseModel> call, Response<TmdbResponseModel> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    TmdbResponseModel popularMovieList =  response.body();
                    for (PopularMovieResultsPOJO popularMovie : popularMovieList.getPopularMoviesResult()) {
                        progressDialog.dismiss();
                        tmdbRecyclerAdapter = new TmdbRecyclerAdapter(TmdbMainActivity.this, popularMovieList.getPopularMoviesResult());
                        binding.recyclerViewFromMainActivity.setAdapter(tmdbRecyclerAdapter);
                        tmdbRecyclerAdapter.notifyDataSetChanged();

                        Log.d("Popular Movie", "onResponse: " + popularMovie.getOriginalTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<TmdbResponseModel> call, Throwable t) {
                progressDialog.hide();
                showLongToast(TmdbMainActivity.this, t.getMessage());
            }
        });


    }
}