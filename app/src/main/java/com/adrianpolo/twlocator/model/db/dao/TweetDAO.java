package com.adrianpolo.twlocator.model.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.adrianpolo.twlocator.model.Tweet;
import com.adrianpolo.twlocator.model.db.DBConstants;

import java.util.LinkedList;

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
        contentValues.put(DBConstants.KEY_TWEET_ID_TWITTER, tweet.getIdTwitter());
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
        String text = c.getString(c.getColumnIndex(DBConstants.KEY_TWEET_TEXT));
        String urlImage = c.getString(c.getColumnIndex(DBConstants.KEY_TWEET_URLIMAGE));
        Double latitude = c.getDouble(c.getColumnIndex(DBConstants.KEY_TWEET_LATITUDE));
        Double longitude = c.getDouble(c.getColumnIndex(DBConstants.KEY_TWEET_LONGITUDE));
        long idTwitter = c.getLong(c.getColumnIndex(DBConstants.KEY_TWEET_ID_TWITTER));
        long city = c.getLong(c.getColumnIndex(DBConstants.KEY_TWEET_CITY));

        Tweet tweet = new Tweet(author,text,urlImage,latitude,longitude,city, idTwitter);

        tweet.setId(id);

        return tweet;
    }

    public LinkedList<Tweet> tweetsForCity(long idCity){
        LinkedList<Tweet> tweets = new LinkedList<>();

        String where = DBConstants.KEY_TWEET_CITY + "=" + Long.toString(idCity);

        Cursor cursor = db.getReadableDatabase().query(getTableName(),
                getAllColums(),
                where,
                null,
                null,
                null,
                getIdRepresentativeValue());

        if(cursor != null){
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                do {
                    Tweet tweet = elementFromCursor(cursor);
                    tweets.add(tweet);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return tweets;
    }

    public Tweet tweetForIdTwitter(long idTwitter){
        Tweet tweet = null;

        String where = DBConstants.KEY_TWEET_ID_TWITTER + "=" + Long.toString(idTwitter);

        Cursor cursor = db.getReadableDatabase().query(getTableName(),
                getAllColums(),
                where,
                null,
                null,
                null,
                null,
                "1");

        if(cursor != null){
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                tweet = elementFromCursor(cursor);
            }
            cursor.close();
        }

        return tweet;
    }
}
