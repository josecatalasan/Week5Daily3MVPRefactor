package com.example.week4daily3okhttp.view.activities.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.example.week4daily3okhttp.R;
import com.example.week4daily3okhttp.model.flickr.FlickrResponse;
import com.example.week4daily3okhttp.model.flickr.ItemsItem;
import com.example.week4daily3okhttp.view.adapters.FlickrImagesAdapter;


import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract{
    private MainActivityPresenter presenter;
    private RecyclerView rvFlickr;
    private FlickrImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvFlickr = findViewById(R.id.rvFlickr);
        presenter = new MainActivityPresenter(this);
        presenter.getFlickrImages();
    }

    private void populateRV(List<ItemsItem> itemList){
        if(adapter == null){
            adapter = new FlickrImagesAdapter(itemList);
            rvFlickr.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            rvFlickr.setAdapter(adapter);
            SnapHelper helper = new LinearSnapHelper();
            helper.attachToRecyclerView(rvFlickr);
        } else {
            adapter.setItemList(itemList);
        }
    }

    @Override
    public void onResult(FlickrResponse flickrResponse) {
        if(flickrResponse != null){
            List<ItemsItem>itemList = flickrResponse.getItems();
            populateRV(itemList);
        }

    }
}
