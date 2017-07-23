package com.niyas.redditlikeapp.adapters.viewholder;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.helpers.RedditUtility;
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
    @BindView(R.id.vote_count_txt)
    TextView voteCountTextView;
    @BindView(R.id.down_vote_arrow)
    public ImageView downVoteImageView;
    @BindView(R.id.up_vote_arrow)
    public ImageView upVoteImageView;
    @BindView(R.id.time_txt)
    TextView timeTextView;

    public RedditPostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindViews(Context context,RedditPostModel redditPostModel) {
        titleTextView.setText(redditPostModel.getTitle());
        bodyTextView.setText(redditPostModel.getPostBody());
        if(redditPostModel.getUpVotes()>0) {
            voteCountTextView.setText(String.valueOf(redditPostModel.getUpVotes()));
        }else if(redditPostModel.getUpVotes() == 0 && redditPostModel.getDownVotes() == 0){
            voteCountTextView.setText(String.valueOf(redditPostModel.getUpVotes()));
        }else if(redditPostModel.getDownVotes()<0){
            voteCountTextView.setText(String.valueOf(redditPostModel.getDownVotes()));
        }
        timeTextView.setText(RedditUtility.getPostDateString(redditPostModel));
        // The last vote is always highlighted. That is if the user's last vote is a down vote, the down arrow is highlighted
        if(redditPostModel.isLastAnUpVote() == null){
            downVoteImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_arrow_downward_black_24dp));
            upVoteImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_arrow_upward_black_24dp));
            return;
        }
        if(redditPostModel.isLastAnUpVote()){
            upVoteImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_arrow_upward_orange_24dp));
            downVoteImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_arrow_downward_black_24dp));
        }else{
            downVoteImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_arrow_downward_violet_24dp));
            upVoteImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_arrow_upward_black_24dp));

        }



    }


}
