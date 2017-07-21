package com.niyas.redditlikeapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.adapters.viewholder.RedditPostViewHolder;
import com.niyas.redditlikeapp.models.RedditPostModel;

import java.util.ArrayList;

/**
 * Created by Niyas Sajjad on 21-Jul-17.
 */

public class RedditPostsRecyclerViewAdapter extends RecyclerView.Adapter<RedditPostViewHolder> {
    private Context context;
    private ArrayList<RedditPostModel> redditPostModels = new ArrayList<>(1);

    public RedditPostsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RedditPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reddit_post_cell, parent, false);

        return new RedditPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RedditPostViewHolder holder, int position) {
        holder.bindViews(redditPostModels.get(position));
    }

    @Override
    public int getItemCount() {
        return redditPostModels.size();
    }

    public void updateDataSet(ArrayList<RedditPostModel> redditPostModels) {
        this.redditPostModels = redditPostModels;
        notifyDataSetChanged();
    }
}
