package com.niyas.redditlikeapp.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Niyas Sajjad on 19-Jul-17.
 */

public class RedditPostModel implements Serializable {
    private String title;
    private String postBody;
    private Date date;
    private String community;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }
}
