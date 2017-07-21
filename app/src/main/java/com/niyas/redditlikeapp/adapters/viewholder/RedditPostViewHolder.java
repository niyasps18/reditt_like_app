package com.niyas.redditlikeapp.adapters.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.models.RedditPostModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Niyas Sajjad on 21-Jul-17.
 */

public class RedditPostViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title_txt)
    TextView titleTextView;
    @BindView(R.id.body_txt)
    TextView bodyTextView;

    public RedditPostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindViews(RedditPostModel redditPostModel) {
        titleTextView.setText(redditPostModel.getTitle());
        bodyTextView.setText(redditPostModel.getPostBody());

    }
}
