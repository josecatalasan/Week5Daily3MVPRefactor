package com.example.week4daily3okhttp.view.activities.MainActivity;

import com.example.week4daily3okhttp.model.datasource.remote.network.okhttp.FlickrAsyncTask;

import java.util.concurrent.ExecutionException;

public class MainActivityPresenter {
    private MainActivityContract contract;

    public MainActivityPresenter(MainActivityContract contract) {
        this.contract = contract;
    }

    protected void getFlickrImages(){
        //Start the asyncTask
        FlickrAsyncTask flickrAsyncTask = new FlickrAsyncTask();
        try {
            contract.onResult(flickrAsyncTask.execute().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
