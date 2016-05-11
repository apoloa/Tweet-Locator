package com.adrianpolo.twlocator.model.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.adrianpolo.twlocator.model.Tweet;
import com.adrianpolo.twlocator.model.db.DBConstants;

public class TweetDAO extends GenericDAO<Tweet> {

    @Override
    protected String getTableName() {
        return DBConstants.TABLE_TWEET;
    }

    @Override
    protected String getIdRepresentativeValue() {
        return DBConstants.KEY_TWEET_ID;
    }

    @Override
    protected ContentValues getContentValues(Tweet tweet) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.KEY_TWEET_AUTHOR, tweet.getAuthor());
        contentValues.put(DBConstants.KEY_TWEET_TEXT, tweet.getText());
        contentValues.put(DBConstants.KEY_TWEET_URLIMAGE, tweet.getUrlImage());
        contentValues.put(DBConstants.KEY_TWEET_LATITUDE, tweet.getLatitude());
        contentValues.put(DBConstants.KEY_TWEET_LONGITUDE, tweet.getLongitude());
        contentValues.put(DBConstants.KEY_TWEET_CITY, tweet.getCity());
        return contentValues;
    }

    @Override
    protected String[] getAllColums() {
        return DBConstants.TABLE_TWEET_ALL_COLUMNS;
    }

    @NonNull
    @Override
    protected Tweet elementFromCursor(@NonNull Cursor c) {
        assert c != null;

        long id = c.getLong(c.getColumnIndex(DBConstants.KEY_TWEET_ID));
        String author = c.getString(c.getColumnIndex(DBConstants.KEY_TWEET_AUTHOR));
        String text = c.getString(c.getColumnIndex(DBConstants.KEY_TWEET_AUTHOR));
        String urlImage = c.getString(c.getColumnIndex(DBConstants.KEY_TWEET_AUTHOR));
        Double latitude = c.getDouble(c.getColumnIndex(DBConstants.KEY_TWEET_AUTHOR));
        Double longitude = c.getDouble(c.getColumnIndex(DBConstants.KEY_TWEET_LONGITUDE));
        long city = c.getLong(c.getColumnIndex(DBConstants.KEY_TWEET_CITY));

        Tweet tweet = new Tweet(author,text,urlImage,latitude,longitude,city);

        tweet.setId(id);

        return tweet;
    }
}
