package com.omdeep.myretrofit.TMDB;

import static com.omdeep.myretrofit.TMDB.Utility.showLongToast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.omdeep.myretrofit.Activity.CommentActivity;
import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.databinding.ActivityTmdbMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TmdbMainActivity extends AppCompatActivity {
    ActivityTmdbMainBinding binding;
    Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityTmdbMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        TmdbApi apiName = TmdbRetrofitApi.getInstance(TmdbApi.class);
        Call<List<TmdbResponseModel>> call = apiName.getPopularMoviesData(Utility.KEY);
        call.enqueue(new Callback<List<TmdbResponseModel>>() {
            @Override
            public void onResponse(Call<List<TmdbResponseModel>> call, Response<List<TmdbResponseModel>> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    List<TmdbResponseModel> popularMovieList = response.body();
                    for (TmdbResponseModel tmdbPopularmovieData : popularMovieList);
                    TmdbRecyclerAdapter tmdbRecyclerAdapter = new TmdbRecyclerAdapter(context, popularMovieList);
                    binding.recyclerViewFromMainActivity.setAdapter(tmdbRecyclerAdapter);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TmdbMainActivity.this);
                    binding.recyclerViewFromMainActivity.setLayoutManager(linearLayoutManager);
                }
            }

            @Override
            public void onFailure(Call<List<TmdbResponseModel>> call, Throwable t) {
                progressDialog.hide();
                showLongToast(TmdbMainActivity.this, t.getMessage());
            }
        });

    }
}