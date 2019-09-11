package com.example.week4daily3okhttp.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.week4daily3okhttp.R;
import com.example.week4daily3okhttp.model.flickr.ItemsItem;
import com.example.week4daily3okhttp.view.dialogues.LongClickDialogue;

import java.util.List;

public class FlickrImagesAdapter extends RecyclerView.Adapter<FlickrImagesAdapter.ViewHolder> {

    private List<ItemsItem> itemList;

    public FlickrImagesAdapter(List<ItemsItem> itemList) {
        this.itemList = itemList;
    }

    public void setItemList(List<ItemsItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.flickr_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsItem currentItem = itemList.get(position);
        holder.tvTaken.setText("Date Taken: " + currentItem.getDateTaken().substring(0,10));
        holder.tvPublished.setText("Date Published: " + currentItem.getPublished().substring(0,10));
        Glide.with(holder.itemView).load(currentItem.getMedia().getM()).circleCrop().into(holder.ivThumbnail);
        holder.tvURL.setText(currentItem.getMedia().getM());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        ImageView ivThumbnail;
        TextView tvTaken, tvPublished, tvURL;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTaken = itemView.findViewById(R.id.tvTaken);
            tvPublished = itemView.findViewById(R.id.tvPublished);
            tvURL = itemView.findViewById(R.id.tvURL);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(final View view) {
            TextView textView = view.findViewById(R.id.tvURL);
            new LongClickDialogue(view.getContext(), textView.getText().toString()).showSelf();
            return true;
        }
    }
}
