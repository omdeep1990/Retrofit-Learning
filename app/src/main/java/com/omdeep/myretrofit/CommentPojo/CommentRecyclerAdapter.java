package com.omdeep.myretrofit.CommentPojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.myretrofit.PostsPojo.PostsResponse;
import com.omdeep.myretrofit.R;

import java.util.List;

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.MyViewHolder> {

    private List<CommentResponse> commentResponseList;
    private Context context;

    public CommentRecyclerAdapter(List<CommentResponse> commentResponseList, Context context) {
        this.commentResponseList = commentResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_display, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentRecyclerAdapter.MyViewHolder holder, int position) {
        CommentResponse commentData = commentResponseList.get(position);
        holder.postId.setText(commentData.getPostId());
        holder.Id.setText(commentData.getId());
        holder.name.setText(commentData.getName());
        holder.email.setText(commentData.getEmail());
        holder.body.setText(commentData.getBody());

    }

    @Override
    public int getItemCount() {
        return commentResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView postId, Id, name, email, body;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postId = itemView.findViewById(R.id.post_Id);
            Id = itemView.findViewById(R.id.Id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);
        }
    }
}
