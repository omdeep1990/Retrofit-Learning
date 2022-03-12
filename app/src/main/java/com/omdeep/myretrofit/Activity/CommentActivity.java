package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.CommentPojo.CommentRecyclerAdapter;
import com.omdeep.myretrofit.CommentPojo.CommentResponse;
import com.omdeep.myretrofit.RetrofitApi;
import com.omdeep.myretrofit.databinding.ActivityCommentBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity{
    ActivityCommentBinding binding;
    Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityCommentBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<CommentResponse>> call = apiName.getCommentsData();
        call.enqueue(new Callback<List<CommentResponse>>() {
            @Override
            public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200) {
                    List<CommentResponse> commentResponses = response.body();
                    for (CommentResponse commentData : commentResponses) {
                        CommentRecyclerAdapter commentRecyclerAdapter = new CommentRecyclerAdapter(commentResponses, CommentActivity.this);
                        binding.recyclerView1.setAdapter(commentRecyclerAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CommentActivity.this);
                        binding.recyclerView1.setLayoutManager(linearLayoutManager);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<CommentResponse>> call, Throwable t) {
                progressDialog.hide();
                showLongToast(CommentActivity.this, t.getMessage());

            }

            private void showLongToast(CommentActivity commentActivity, String msg) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });


    }
}