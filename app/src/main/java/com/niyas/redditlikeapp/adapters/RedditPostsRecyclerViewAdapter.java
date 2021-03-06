package com.niyas.redditlikeapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.adapters.viewholder.RedditPostViewHolder;
import com.niyas.redditlikeapp.helpers.RedditPostDataHelper;
import com.niyas.redditlikeapp.models.RedditPostModel;

import java.util.ArrayList;

/**
 * Created by Niyas Sajjad on 21-Jul-17.
 */

public class RedditPostsRecyclerViewAdapter extends RecyclerView.Adapter<RedditPostViewHolder> {
    private Context context;
    private ArrayList<RedditPostModel> redditPostModels = new ArrayList<>(1);
    private int displaySize = 0;

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
    public void onBindViewHolder(RedditPostViewHolder holder, final int position) {
        holder.bindViews(context,redditPostModels.get(position));
        holder.downVoteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RedditPostDataHelper.getSharedInstance().downVoted(position);
                notifyDataSetChanged();

            }
        });

        holder.upVoteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RedditPostDataHelper.getSharedInstance().upVoted(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(displaySize > redditPostModels.size()) {
            return redditPostModels.size();
        }
        else {
            return displaySize;
        }
    }

    public void updateDataSet(ArrayList<RedditPostModel> redditPostModels) {
        this.redditPostModels = redditPostModels;
        RedditPostDataHelper.getSharedInstance().sortByUpVotes();
        notifyDataSetChanged();
    }

    public void setDisplaySize(int displaySize){
        this.displaySize = displaySize;
        notifyDataSetChanged();
    }
}
