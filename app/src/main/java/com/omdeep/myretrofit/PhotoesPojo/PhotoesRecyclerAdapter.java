package com.omdeep.myretrofit.PhotoesPojo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.omdeep.myretrofit.R;

import java.util.List;

public class PhotoesRecyclerAdapter extends RecyclerView.Adapter<PhotoesRecyclerAdapter.ViewHolder> {
    private List<PhotoesResponse> photoesResponseList;
    //String url = 'https://via.placeholder.com/600/92c952';
    private Context context;

    public PhotoesRecyclerAdapter(List<PhotoesResponse> photoesResponseList, Context context) {
        this.photoesResponseList = photoesResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotoesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.photo_display, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoesRecyclerAdapter.ViewHolder holder, int position) {
        PhotoesResponse photodata = photoesResponseList.get(position);
        holder.albumId.setText(photodata.getAlbumId());
        holder.id.setText(photodata.getId());
        holder.title.setText(photodata.getTitle());

        //TODO: Adding Glide library to display images
        Glide.with(context).load(photoesResponseList.get(position).getUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return photoesResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView albumId, id, title;
        ImageView image, image1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumId = itemView.findViewById(R.id.album_Id);
            id = itemView.findViewById(R.id.id6);
            title = itemView.findViewById(R.id.title3);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
