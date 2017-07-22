package com.niyas.redditlikeapp.helpers;

import android.util.Log;

import com.niyas.redditlikeapp.models.RedditPostModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Niyas Sajjad on 21-Jul-17.
 */

public class RedditUtility {
    public static String getDateStringFromDate(Date date) {
        if (date == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(RedditConstants.DATE_FORMAT, Locale.US);
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(date);

    }

    public static String  getPostDateString(RedditPostModel redditPostModel){
        Calendar calendar = Calendar.getInstance();
        long seconds, minutes,hours,days,months,years;
        long difference =  calendar.getTimeInMillis() - redditPostModel.getDate().getTime() ;

        long x = difference / 1000;
        seconds = x % 60;
        x /= 60;
        minutes = x % 60;
        x /= 60;
        hours = x % 24;
        x /= 24;
        days = x;
        if (minutes == 0){
            return "now";
        }else if(minutes>0 && minutes <60){
            return String.valueOf(minutes)+"m";
        }else if(hours > 0 && hours < 24){
            return String.valueOf(hours)+"h";
        }else if(days>0 && days <31){
            return String.valueOf(days)+"d";
        }
        Log.e("djfkdjf",""+minutes+", "+hours+" "+days+" ,"+seconds);
        return "";
    }
}
