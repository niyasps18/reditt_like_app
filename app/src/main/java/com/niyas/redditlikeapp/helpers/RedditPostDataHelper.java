package com.niyas.redditlikeapp.helpers;

import com.niyas.redditlikeapp.models.RedditPostModel;

import java.util.ArrayList;

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
        if(sharedInstance == null){
            sharedInstance = new RedditPostDataHelper();
        }
        return sharedInstance;
    }


}
