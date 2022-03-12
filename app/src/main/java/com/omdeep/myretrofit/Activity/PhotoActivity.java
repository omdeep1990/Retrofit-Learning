package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.omdeep.myretrofit.Albums.AlbumRecyclerAdapter;
import com.omdeep.myretrofit.Albums.AlbumResponse;
import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.PhotoesPojo.PhotoesRecyclerAdapter;
import com.omdeep.myretrofit.PhotoesPojo.PhotoesResponse;
import com.omdeep.myretrofit.RetrofitApi;
import com.omdeep.myretrofit.databinding.ActivityPhotoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {
    ActivityPhotoBinding binding;
    Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityPhotoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<PhotoesResponse>> call = apiName.getPhotoData();
        call.enqueue(new Callback<List<PhotoesResponse>>() {
            @Override
            public void onResponse(Call<List<PhotoesResponse>> call, Response<List<PhotoesResponse>> response) {
                progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200) {
                    List<PhotoesResponse> photoesResponses = response.body();
                    for (PhotoesResponse photoData : photoesResponses) {
                        PhotoesRecyclerAdapter photoesRecyclerAdapter = new PhotoesRecyclerAdapter(photoesResponses, PhotoActivity.this);
                        binding.recyclerView5.setAdapter(photoesRecyclerAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PhotoActivity.this);
                        binding.recyclerView5.setLayoutManager(linearLayoutManager);
                }
            }

        }

            @Override
            public void onFailure(Call<List<PhotoesResponse>> call, Throwable t) {
                progressDialog.hide();
                showLongToast(PhotoActivity.this, t.getMessage());

            }

            private void showLongToast(PhotoActivity albumActivity, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });


    }
}