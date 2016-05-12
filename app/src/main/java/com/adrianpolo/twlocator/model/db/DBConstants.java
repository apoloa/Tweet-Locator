package com.adrianpolo.twlocator.model.db;

public class DBConstants {

    public static final String DB_NAME = "TWLocator.sqlite";

    public static final String TABLE_TWEET = "TWEET";
    public static final String TABLE_CITY = "CITY";

    public static final String KEY_TWEET_ID = "_id";
    public static final String KEY_TWEET_AUTHOR = "author";
    public static final String KEY_TWEET_TEXT = "text";
    public static final String KEY_TWEET_URLIMAGE = "urlimage";
    public static final String KEY_TWEET_LATITUDE = "latitude";
    public static final String KEY_TWEET_LONGITUDE = "longitude";
    public static final String KEY_TWEET_CITY = "city";
    public static final String KEY_TWEET_ID_TWITTER = "id_twitter";

    public static final String KEY_CITY_ID = "_id";
    public static final String KEY_CITY_NAME = "name";
    public static final String KEY_CITY_LATITUDE = "latitude";
    public static final String KEY_CITY_LONGITUDE = "longitude";

    public static final String[] TABLE_TWEET_ALL_COLUMNS = {
            KEY_TWEET_ID,
            KEY_TWEET_AUTHOR,
            KEY_TWEET_TEXT,
            KEY_TWEET_URLIMAGE,
            KEY_TWEET_LATITUDE,
            KEY_TWEET_LONGITUDE,
            KEY_TWEET_CITY,
            KEY_TWEET_ID_TWITTER
    };

    public static final String[] TABLE_CITY_ALL_COLUMNS = {
            KEY_CITY_ID,
            KEY_CITY_NAME,
            KEY_CITY_LATITUDE,
            KEY_CITY_LONGITUDE
    };


    public static final String SQL_CREATE_TWEET_TABLE =
            "CREATE TABLE " + TABLE_TWEET
                    + "( "
                    + KEY_TWEET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_TWEET_AUTHOR + " TEXT NOT NULL, "
                    + KEY_TWEET_TEXT + " TEXT NOT NULL, "
                    + KEY_TWEET_URLIMAGE + " TEXT NOT NULL, "
                    + KEY_TWEET_LATITUDE + " REAL NOT NULL, "
                    + KEY_TWEET_LONGITUDE + " REAL NOT NULL, "
                    + KEY_TWEET_CITY + " INTEGER NOT NULL, "
                    + KEY_TWEET_ID_TWITTER + " INTEGER NOT NULL "
                + ");";

    public static final String SQL_CREATE_CITY_TABLE =
            "CREATE TABLE " + TABLE_CITY
                    + "( "
                    + KEY_CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_CITY_NAME + " TEXT NOT NULL, "
                    + KEY_CITY_LONGITUDE + " REAL NOT NULL, "
                    + KEY_CITY_LATITUDE + " REAL NOT NULL "
                    + ");";
}
