package com.niyas.redditlikeapp;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.niyas.redditlikeapp.activities.HomeActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;

/**
 * Created by Niyas Sajjad on 24-Jul-17.
 */

public class RedditLikeAppTest {

    @Rule
    public ActivityTestRule<HomeActivity> redditMakePostActivityRule =
            new ActivityTestRule<>(HomeActivity.class, true, true);


    @Test
    public void checkIfNewPostPageOpened(){
        redditMakePostActivityRule.launchActivity(new Intent());
        performFabClick();
    }

    private void performFabClick(){
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(click());
    }

    @Test
    public void checkIfPostIsCreatedSuccessfully(){
        performFabClick();
        Espresso.onView(ViewMatchers.withId(R.id.title_edit_txt)).perform(typeText("This is a test title"));
        Espresso.onView(ViewMatchers.withId(R.id.body_edit_txt)).perform(typeText("This is a test post via espresso"));
        Espresso.onView(ViewMatchers.withId(R.id.post_txt_view)).perform(click());

    }
}
