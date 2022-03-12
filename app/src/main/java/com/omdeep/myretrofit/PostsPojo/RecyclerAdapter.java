package com.omdeep.myretrofit.PostsPojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.myretrofit.OnItemClickListner;
import com.omdeep.myretrofit.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private OnItemClickListner listner;
    private List<PostsResponse> postsResponseList;
    private Context context;

    public RecyclerAdapter(Context context, List<PostsResponse> postsResponseList) {
        this.context = context;
        this.postsResponseList = postsResponseList;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.datadisplay, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        PostsResponse postdata = postsResponseList.get(position);
        holder.userId.setText(postdata.getUserId());
        holder.Id.setText(postdata.getId());
        holder.title.setText(postdata.getTitle());
        holder.body.setText(postdata.getBody());
    }

    @Override
    public int getItemCount() {

        return postsResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, Id, title, body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.user_Id);
            Id = itemView.findViewById(R.id.Id);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
