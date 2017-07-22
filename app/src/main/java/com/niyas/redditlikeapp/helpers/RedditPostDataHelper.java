package com.niyas.redditlikeapp.helpers;

import android.content.Context;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.models.RedditPostModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Niyas Sajjad on 20-Jul-17.
 */

public class RedditPostDataHelper {

    private static RedditPostDataHelper sharedInstance;
    private ArrayList<RedditPostModel> redditPostArrayList = new ArrayList<>(1);

    public ArrayList<RedditPostModel> getRedditPostArrayList() {
        return redditPostArrayList;
    }

    public void setRedditPostArrayList(ArrayList<RedditPostModel> redditPostArrayList) {
        this.redditPostArrayList = redditPostArrayList;
    }

    public static RedditPostDataHelper getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new RedditPostDataHelper();
        }
        return sharedInstance;
    }

    public void clearAllData() {
        redditPostArrayList.clear();
    }

    public void upVoted(int position) {
        redditPostArrayList.get(position).setLastAnUpVote(true);
        redditPostArrayList.get(position).setUpVotes(redditPostArrayList.get(position).getUpVotes() + 1);
        sortByUpVotes();
    }

    public void downVoted(int position) {
        redditPostArrayList.get(position).setLastAnUpVote(false);
        redditPostArrayList.get(position).setDownVotes(redditPostArrayList.get(position).getDownVotes() + 1);
        //comment this if number of upvotes need not to be reduced as the user down votes
        if (redditPostArrayList.get(position).getUpVotes() > 0) {
            redditPostArrayList.get(position).setUpVotes(redditPostArrayList.get(position).getUpVotes() - 1);
        }
        sortByUpVotes();
    }

    public void sortByUpVotes(){
        Collections.sort(redditPostArrayList, new Comparator<RedditPostModel>() {
            @Override
            public int compare(RedditPostModel o1, RedditPostModel o2) {
                if(o1.getUpVotes() > o2.getUpVotes()){
                    return -1;
                }else if(o2.getUpVotes() > o1.getUpVotes()){
                    return 1;
                }else if(o2.getUpVotes() == o1.getUpVotes()){
                    return 0;
                }else{
                    return  0;
                }
            }
        });
    }

    public ArrayList<RedditPostModel> populateInitialListData(Context context){
        for(int i = 0 ;i<10; i++){
            RedditPostModel redditPostModel = new RedditPostModel();
            redditPostModel.setPostBody(context.getResources().getStringArray(R.array.initial_list_body_data)[i]);
            redditPostModel.setUpVotes(0);
            redditPostModel.setDownVotes(0);
            redditPostModel.setDate(new Date());
            redditPostArrayList.add(redditPostModel);
        }

        return redditPostArrayList;
    }
}
