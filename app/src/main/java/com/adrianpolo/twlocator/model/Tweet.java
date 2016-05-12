package com.adrianpolo.twlocator.model;

import com.adrianpolo.twlocator.model.db.dao.Persistable;

import java.io.Serializable;

/**
 * Created by Adri on 08/05/16.
 */
public class Tweet implements Serializable, Persistable {
    private long mId;
    private String mAuthor;
    private String mText;
    private String mUrlImage;
    private double mLatitude;
    private double mLongitude;
    private long mCity;
    private long mIdTwitter;

    public Tweet(String author, String text, String uriImage, double latitude, double longitude, long city, long idTwitter) {
        this.mAuthor = author;
        this.mText = text;
        this.mUrlImage = uriImage;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mCity = city;
        this.mIdTwitter = idTwitter;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String mUriImage) {
        this.mUrlImage = mUriImage;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public long getId() {
        return mId;
    }

    @Override
    public void setId(long id) {
        this.mId = id;
    }

    public long getCity() {
        return mCity;
    }

    public void setCity(long mLocation) {
        this.mCity = mLocation;
    }

    public long getIdTwitter() {
        return mIdTwitter;
    }

    public void setIdTwitter(long idTwitter) {
        mIdTwitter = idTwitter;
    }
}
