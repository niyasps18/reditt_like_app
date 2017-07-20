package com.niyas.redditlikeapp.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.niyas.redditlikeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RedditMakePostActivity extends BaseActivity {
    @BindView(R.id.page_header_txt_view)
    TextView pageHeaderTextView;
    @BindView(R.id.post_txt_view)
    TextView postTextView;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddit_make_post);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pageHeaderTextView.setText(getResources().getString(R.string.make_a_post));
    }
}
