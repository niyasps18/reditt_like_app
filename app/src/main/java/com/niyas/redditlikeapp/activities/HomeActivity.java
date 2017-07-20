package com.niyas.redditlikeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

import com.niyas.redditlikeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.page_header_txt_view)
    TextView pageHeaderTextView;
    @BindView(R.id.post_txt_view)
    TextView postTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pageHeaderTextView.setText("Reddit Home");


    }


    @OnClick(R.id.fab)
    public void onFabClicked(){
        Intent intent = new Intent(this, RedditMakePostActivity.class);
        startActivity(intent);
    }
}
