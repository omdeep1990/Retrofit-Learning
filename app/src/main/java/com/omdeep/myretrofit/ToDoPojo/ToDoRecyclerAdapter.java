package com.omdeep.myretrofit.ToDoPojo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.myretrofit.R;

import java.util.List;

public class ToDoRecyclerAdapter extends RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder> {
    private List<ToDoResponse> toDoResponseList;
    private Context context;

    public ToDoRecyclerAdapter(List<ToDoResponse> toDoResponseList, Context context) {
        this.toDoResponseList = toDoResponseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ToDoRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_display, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoRecyclerAdapter.ViewHolder holder, int position) {
        ToDoResponse toDoData = toDoResponseList.get(position);
        holder.userId.setText(toDoData.getUserId());
        holder.id.setText(toDoData.getId());
        holder.title.setText(toDoData.getTitle());
        holder.completed.setText(toDoData.getCompleted());
    }

    @Override
    public int getItemCount() {
        return toDoResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, id, title, completed;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId1);
            id = itemView.findViewById(R.id.id4);
            title = itemView.findViewById(R.id.title1);
            completed = itemView.findViewById(R.id.completed);
        }
    }
}
