package com.example.week4daily3okhttp.view.dialogues;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import com.example.week4daily3okhttp.view.activities.FullImageActivity.FullImageActivity;

public class LongClickDialogue implements DialogInterface.OnClickListener {
    private Context context;
    private String imageUrl;

    public LongClickDialogue(Context context, String imageUrl) {
        this.context = context;
        this.imageUrl = imageUrl;
    }

    public void showSelf(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("What would you like to do?").setPositiveButton("See Full Image", this)
                .setNegativeButton("See Small Image",this).show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int choice) {
        switch(choice) {
            case DialogInterface.BUTTON_POSITIVE:
                Intent intent = new Intent(context, FullImageActivity.class);
                intent.putExtra("picture", imageUrl);
                context.startActivity(intent);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                new SmallImageDialogue(context,imageUrl).showSelf();
                break;
        }

    }
}
