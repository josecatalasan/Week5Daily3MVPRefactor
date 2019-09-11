package com.example.week4daily3okhttp.view.activities.FullImageActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.week4daily3okhttp.R;

public class FullImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        ImageView ivFullImage = findViewById(R.id.ivFullImage);
        Glide.with(ivFullImage).load(getIntent().getStringExtra("picture")).into(ivFullImage);
    }
}
