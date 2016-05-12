package com.adrianpolo.twlocator.model;

import com.adrianpolo.twlocator.model.db.dao.Persistable;

public class City implements Persistable{
    private long mId;
    private String mCity;
    private double mLatitude;
    private double mLongitude;

    public City(String city, double latitude, double longitude) {
        mCity = city;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public long getId() {
        return mId;
    }

    @Override
    public void setId(long id) {
        mId = id;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }


}
