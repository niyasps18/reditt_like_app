package com.niyas.redditlikeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.adapters.RedditPostsRecyclerViewAdapter;
import com.niyas.redditlikeapp.helpers.RedditPostDataHelper;

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
    @BindView(R.id.posts_recycler_view)
    RecyclerView postsRecyclerView;
    @BindView(R.id.no_posts_txt_view)
    TextView noPostsTextView;
    private RedditPostsRecyclerViewAdapter redditPostsRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int displaySize = 20;
    private boolean isLoadingMore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        unbinder = ButterKnife.bind(this);
        init();

    }

    private void init() {
        setSupportActionBar(toolbar);
        pageHeaderTextView.setText("Reddit Home");
        redditPostsRecyclerViewAdapter = new RedditPostsRecyclerViewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        postsRecyclerView.setLayoutManager(linearLayoutManager);
        postsRecyclerView.setAdapter(redditPostsRecyclerViewAdapter);
        redditPostsRecyclerViewAdapter.setDisplaySize(displaySize);
        redditPostsRecyclerViewAdapter.updateDataSet(RedditPostDataHelper.getSharedInstance().populateInitialListData(this));
        manageNoPostsLabel();
        setScrollListenerForRecyclerView();
    }

    private void setScrollListenerForRecyclerView() {
        postsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = RedditPostDataHelper.getSharedInstance().getRedditPostArrayList().size();
                int lastInScreen = firstVisibleItem + visibleItemCount;

                if (lastInScreen == displaySize &!isLoadingMore) {
                    isLoadingMore = true;
                    if(displaySize>=totalItemCount){
                        return;
                    }

                    Toast.makeText(HomeActivity.this,"Loading more",Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            displaySize += 10;
                            redditPostsRecyclerViewAdapter.setDisplaySize(displaySize);
                            isLoadingMore = false;
                        }
                    },5000);
                }
            }
        });
    }


    @OnClick(R.id.fab)
    public void onFabClicked() {
        Intent intent = new Intent(this, RedditMakePostActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == 100) {
                manageNoPostsLabel();
                redditPostsRecyclerViewAdapter.updateDataSet(RedditPostDataHelper.getSharedInstance().getRedditPostArrayList());
            }
        }
    }

    /**
     * If there are no posts available, then this message will be shown to prompt user to add a new post
     */
    private void manageNoPostsLabel() {
        if (RedditPostDataHelper.getSharedInstance().getRedditPostArrayList() != null && RedditPostDataHelper.getSharedInstance().getRedditPostArrayList().size() > 0) {
            noPostsTextView.setVisibility(View.GONE);
        } else {
            noPostsTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder !=null) {
            unbinder.unbind();
        }
        RedditPostDataHelper.getSharedInstance().clearAllData();
    }
}
