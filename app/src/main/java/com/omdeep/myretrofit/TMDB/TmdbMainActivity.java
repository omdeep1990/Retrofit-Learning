package com.omdeep.myretrofit.TMDB;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omdeep.myretrofit.databinding.ActivityTmdbMainBinding;

public class TmdbMainActivity extends AppCompatActivity {
    ActivityTmdbMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityTmdbMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


    }
}