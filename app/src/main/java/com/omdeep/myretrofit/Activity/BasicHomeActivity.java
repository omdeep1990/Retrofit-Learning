package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.TMDB.TmdbMainActivity;
import com.omdeep.myretrofit.databinding.ActivityBasicHomeBinding;

public class BasicHomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityBasicHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityBasicHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.json.setOnClickListener(this);
        binding.tmdb.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.json:
                Intent intent = new Intent(BasicHomeActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.tmdb:
                startActivity(new Intent(BasicHomeActivity.this, TmdbHomeActivity.class));
                break;
            case R.id.weather:

            case R.id.rapidApi:
        }
    }
}