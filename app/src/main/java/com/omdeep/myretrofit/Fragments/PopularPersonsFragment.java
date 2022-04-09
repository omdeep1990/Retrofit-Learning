package com.omdeep.myretrofit.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omdeep.myretrofit.ApiName;
import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.TMDB.PopularPersonListAdapter;
import com.omdeep.myretrofit.TMDB.PopularPersonResponse;
import com.omdeep.myretrofit.TMDB.TmdbApi;
import com.omdeep.myretrofit.TMDB.TmdbRetrofitApi;
import com.omdeep.myretrofit.TMDB.Utility;
import com.omdeep.myretrofit.databinding.FragmentPopularMoviesBinding;
import com.omdeep.myretrofit.databinding.FragmentPopularPersonsBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularPersonsFragment extends Fragment {
    private FragmentPopularPersonsBinding binding;
    ProgressDialog progressDialog;
    PopularPersonListAdapter listAdapeter;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding.recyclerViewOfPopularPerson.setLayoutManager(new GridLayoutManager(getContext(), GridLayoutManager.VERTICAL));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPopularPersonsBinding.inflate(inflater, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        TmdbApi apiname = TmdbRetrofitApi.getInstance(TmdbApi.class);
        Call<PopularPersonResponse> call = apiname.getPopularPerson(Utility.KEY);
        call.enqueue(new Callback<PopularPersonResponse>() {
            @Override
            public void onResponse(Call<PopularPersonResponse> call, Response<PopularPersonResponse> response) {
                if(response.isSuccessful() && response.code() == 200) {
                    progressDialog.dismiss();
                    PopularPersonResponse personResponse = response.body();
                    assert personResponse != null;
                    listAdapeter = new PopularPersonListAdapter(personResponse.getPopularPersonResult(), context);
                    binding.recyclerViewOfPopularPerson.setLayoutManager(new GridLayoutManager(getContext(), GridLayoutManager.VERTICAL));
                    binding.recyclerViewOfPopularPerson.setAdapter(listAdapeter);
                    listAdapeter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PopularPersonResponse> call, Throwable t) {
                Utility.showLongToast(getContext(), t.getMessage());
            }
        });


        return binding.getRoot();
    }
}