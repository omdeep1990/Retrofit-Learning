package com.omdeep.myretrofit.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.databinding.FragmentPopularMoviesBinding;

public class PopularMoviesFragment extends Fragment {
    private FragmentPopularMoviesBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPopularMoviesBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }
}