package com.omdeep.myretrofit.Albums;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.myretrofit.PostsPojo.RecyclerAdapter;
import com.omdeep.myretrofit.R;

import java.util.List;

public class AlbumRecyclerAdapter extends RecyclerView.Adapter<AlbumRecyclerAdapter.ViewHolder> {
    private List<AlbumResponse> albumResponseList;
    private Context context;

    public AlbumRecyclerAdapter(List<AlbumResponse> albumResponseList, Context context) {
        this.albumResponseList = albumResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_display, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumRecyclerAdapter.ViewHolder holder, int position) {
        AlbumResponse albumData = albumResponseList.get(position);
        holder.userId.setText(albumData.getId());
        holder.Id.setText(albumData.getId());
        holder.title.setText(albumData.getTitle());
    }

    @Override
    public int getItemCount() {
        return albumResponseList.size();
    }

    public class
    ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, Id, title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            Id = itemView.findViewById(R.id.id2);
            title = itemView.findViewById(R.id.title2);
        }
    }
}
