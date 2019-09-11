package com.example.week4daily3okhttp.view.dialogues;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.example.week4daily3okhttp.R;

public class SmallImageDialogue {
    private Context context;
    private String imageUrl;

    public SmallImageDialogue(Context context, String imageUrl) {
        this.context = context;
        this.imageUrl = imageUrl;
    }

    public void showSelf(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater factory = LayoutInflater.from(context);
        @SuppressLint("InflateParams") final View dialogView = factory.inflate(R.layout.dialog_image, null);
        ImageView image = dialogView.findViewById(R.id.ivDialogImage);
        Glide.with(dialogView).load(imageUrl).into(image);
        builder.setView(dialogView).show();
    }
}
