package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.RetrofitApi;
import com.omdeep.myretrofit.UserPojo.AddressUserResponse;
import com.omdeep.myretrofit.UserPojo.CompanyUserResponse;
import com.omdeep.myretrofit.UserPojo.GeoUserResponse;
import com.omdeep.myretrofit.UserPojo.UserRecyclerAdapter;
import com.omdeep.myretrofit.UserPojo.UsersResponse;
import com.omdeep.myretrofit.databinding.ActivityUsersBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {
    ActivityUsersBinding binding;
    Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<UsersResponse>> call  = apiName.getUsersData();
        call.enqueue(new Callback<List<UsersResponse>>() {
            @Override
            public void onResponse(Call<List<UsersResponse>> call, Response<List<UsersResponse>> response) {
                progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200) {
                    List<UsersResponse> usersResponses = response.body();
                    for (UsersResponse userData : usersResponses) {
                        UserRecyclerAdapter userRecyclerAdapter = new UserRecyclerAdapter(usersResponses, UsersActivity.this);
                        binding.recyclerView2.setAdapter(userRecyclerAdapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UsersActivity.this);
                        binding.recyclerView2.setLayoutManager(linearLayoutManager);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UsersResponse>> call, Throwable t) {

            }
        });
    }
}