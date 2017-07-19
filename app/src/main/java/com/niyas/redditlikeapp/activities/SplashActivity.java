package com.niyas.redditlikeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.niyas.redditlikeapp.R;

public class SplashActivity extends BaseActivity {
    private final int SPLASH_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_DELAY);
    }
}
