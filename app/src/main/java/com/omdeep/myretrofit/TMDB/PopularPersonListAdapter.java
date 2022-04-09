package com.omdeep.myretrofit.TMDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.omdeep.myretrofit.databinding.PopularPersonDisplayBinding;

import java.util.List;

public class PopularPersonListAdapter extends RecyclerView.Adapter<PopularPersonListAdapter.MyViewHolder> {
    private List<PopularPersonResultsPOJO> list;
    Context context;

    public PopularPersonListAdapter(List<PopularPersonResultsPOJO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PopularPersonDisplayBinding binding = PopularPersonDisplayBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String profileDP = Utility.IMAGE_BASE_URL + list.get(position).getProfilePath();
        Glide.with(context).load(profileDP).into(holder.binding.imageViewPopularPerson);

        holder.binding.textViewTrendingPeopleName.setText(list.get(position).getName());
        holder.binding.textViewTrendingPeopleWork.setText("Profession : " + list.get(position).getKnownForDepartment());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        PopularPersonDisplayBinding binding;
        public MyViewHolder(PopularPersonDisplayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
