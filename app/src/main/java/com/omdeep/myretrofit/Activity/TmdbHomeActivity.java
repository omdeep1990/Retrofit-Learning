package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omdeep.myretrofit.Fragments.PopularMoviesFragment;
import com.omdeep.myretrofit.Fragments.PopularPersonsFragment;
import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.TMDB.TmdbMainActivity;
import com.omdeep.myretrofit.databinding.ActivityTmdbHomeBinding;

public class TmdbHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityTmdbHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTmdbHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cardViewMovies.setOnClickListener(this);
        binding.popularPersons.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardViewMovies:
//                PopularMovies(new PopularMoviesFragment());

                startActivity(new Intent(TmdbHomeActivity.this, TmdbMainActivity.class));
                break;
            case R.id.popular_persons:
                PopularPersons(new PopularPersonsFragment());
                break;
        }
    }

    //TODO: To replace with Popular Movies fragment
    private void PopularMovies(PopularMoviesFragment popularMoviesFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_container, popularMoviesFragment);
        fragmentTransaction.commit();
    }

    //TODO: To replace with Popular Persons fragment
    private void PopularPersons(PopularPersonsFragment personsFragment) {
        binding.layout1.setVisibility(View.INVISIBLE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, personsFragment);
        fragmentTransaction.commit();
    }
}