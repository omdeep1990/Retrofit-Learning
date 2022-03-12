package com.omdeep.myretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omdeep.myretrofit.R;
import com.omdeep.myretrofit.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.post.setOnClickListener(this);
        binding.comment.setOnClickListener(this);
        binding.users.setOnClickListener(this);
        binding.todo.setOnClickListener(this);
        binding.albums.setOnClickListener(this);
        binding.photoes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.post:
                Intent intent =new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.comment:
               Intent in =new Intent(HomeActivity.this, CommentActivity.class);
               startActivity(in);
               break;
            case R.id.albums:
                Intent intent2 = new Intent(HomeActivity.this, AlbumActivity.class);
                startActivity(intent2);
                break;
            case R.id.photoes:
                Intent intent4 = new Intent(HomeActivity.this, PhotoActivity.class);
                startActivity(intent4);
                break;
            case R.id.todo:
                Intent intent3 = new Intent(HomeActivity.this, ToDoActivity.class);
                startActivity(intent3);
                break;
            case R.id.users:
                Intent intent1 = new Intent(HomeActivity.this, UsersActivity.class);
                startActivity(intent1);
                break;
        }
    }
}