package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.hardware.lights.LightsManager;
import android.os.Bundle;

import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.RetrofitApi;
import com.omdeep.myretrofit.ToDoPojo.ToDoRecyclerAdapter;
import com.omdeep.myretrofit.ToDoPojo.ToDoResponse;
import com.omdeep.myretrofit.databinding.ActivityToDoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToDoActivity extends AppCompatActivity {
    ActivityToDoBinding binding;
    Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityToDoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<ToDoResponse>> call = apiName.getToDoData();
        call.enqueue(new Callback<List<ToDoResponse>>() {
            @Override
            public void onResponse(Call<List<ToDoResponse>> call, Response<List<ToDoResponse>> response) {
                progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200) {
                    List<ToDoResponse> toDoResponses = response.body();
                    for (ToDoResponse toDoData : toDoResponses) {
                        ToDoRecyclerAdapter toDoRecyclerAdapter = new ToDoRecyclerAdapter(toDoResponses, ToDoActivity.this);
                        binding.recyclerView3.setAdapter(toDoRecyclerAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ToDoActivity.this);
                        binding.recyclerView3.setLayoutManager(linearLayoutManager);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ToDoResponse>> call, Throwable t) {

            }
        });
    }
}