package com.niyas.redditlikeapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.niyas.redditlikeapp.R;
import com.niyas.redditlikeapp.helpers.RedditPostDataHelper;
import com.niyas.redditlikeapp.models.RedditPostModel;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RedditMakePostActivity extends BaseActivity {
    @BindView(R.id.page_header_txt_view)
    TextView pageHeaderTextView;
    @BindView(R.id.post_txt_view)
    TextView postTextView;
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.title_edit_txt)
    EditText titleEditText;
    @BindView(R.id.body_edit_txt)
    EditText bodyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reddit_make_post);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pageHeaderTextView.setText(getResources().getString(R.string.make_a_post));
        postTextView.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.post_txt_view)
    public void onPostClicked(){
        postAndUpdateList();
    }

    private void postAndUpdateList() {
        RedditPostModel redditPostModel = new RedditPostModel();
        redditPostModel.setTitle(titleEditText.getText().toString().trim());
        redditPostModel.setPostBody(bodyEditText.getText().toString().trim());
        redditPostModel.setDate(new Date());
        RedditPostDataHelper.getSharedInstance().getRedditPostArrayList().add(redditPostModel);
        setResult(100);
        finish();
    }
}
