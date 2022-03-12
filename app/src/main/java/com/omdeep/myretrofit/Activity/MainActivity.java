package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.PostsPojo.PostsResponse;
import com.omdeep.myretrofit.PostsPojo.RecyclerAdapter;
import com.omdeep.myretrofit.RetrofitApi;
import com.omdeep.myretrofit.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class MainActivity extends AppCompatActivity {
        ActivityMainBinding binding;
        Context context;
        private ProgressDialog progressDialog;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            super.onCreate(savedInstanceState);
            setContentView(binding.getRoot());

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            ApiName apiName = RetrofitApi.getInstance(ApiName.class);
            Call<List<PostsResponse>> call = apiName.getPostsData();
            call.enqueue(new Callback<List<PostsResponse>>() {
                @Override
                public void onResponse(Call<List<PostsResponse>> call, Response<List<PostsResponse>> response) {
                    progressDialog.hide();
                    if (response.isSuccessful() && response.code() == 200){
                        List<PostsResponse> postsResponses = response.body();
                        for (PostsResponse postData : postsResponses){
                            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(MainActivity.this,postsResponses);
                            binding.recyclerView.setAdapter(recyclerAdapter);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                            binding.recyclerView.setLayoutManager(linearLayoutManager);
                        }
                    }

                }
                public void showLongToast(Context context, String msg){
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<PostsResponse>> call, Throwable t) {
                    progressDialog.hide();
                    showLongToast(MainActivity.this, t.getMessage());
                }
            });



        }


    }