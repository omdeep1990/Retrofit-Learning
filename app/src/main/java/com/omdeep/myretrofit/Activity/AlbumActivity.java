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
import com.omdeep.myretrofit.RetrofitApi;
import com.omdeep.myretrofit.databinding.ActivityAlbumBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {
    ActivityAlbumBinding binding;
    Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAlbumBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<AlbumResponse>> call = apiName.getAlbumData();
        call.enqueue(new Callback<List<AlbumResponse>>() {
            @Override
            public void onResponse(Call<List<AlbumResponse>> call, Response<List<AlbumResponse>> response) {
                progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200) {
                    List<AlbumResponse> albumResponses = response.body();
                    for (AlbumResponse albumData : albumResponses) {
                        AlbumRecyclerAdapter albumRecyclerAdapter = new AlbumRecyclerAdapter(albumResponses, AlbumActivity.this);
                        binding.recyclerView4.setAdapter(albumRecyclerAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AlbumActivity.this);
                        binding.recyclerView4.setLayoutManager(linearLayoutManager);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<AlbumResponse>> call, Throwable t) {
                progressDialog.hide();
                showLongToast(AlbumActivity.this, t.getMessage());

            }

            private void showLongToast(AlbumActivity albumActivity, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });


    }
}