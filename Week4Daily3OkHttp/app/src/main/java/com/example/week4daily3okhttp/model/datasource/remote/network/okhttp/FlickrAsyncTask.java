package com.example.week4daily3okhttp.model.datasource.remote.network.okhttp;

import android.os.AsyncTask;

import com.example.week4daily3okhttp.model.flickr.FlickrResponse;
import com.google.gson.Gson;

import java.io.IOException;

public class FlickrAsyncTask extends AsyncTask<Void, String, FlickrResponse> {

    @Override
    public FlickrResponse doInBackground(Void... voids) {
        OkHttpHelper okHttpHelper = new OkHttpHelper();
        String json;
        try{
            json = okHttpHelper.executeSyncOkHttpRequest();
            Gson gson = new Gson();
            FlickrResponse flickrResponse = gson.fromJson(json, FlickrResponse.class);
            return flickrResponse;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
