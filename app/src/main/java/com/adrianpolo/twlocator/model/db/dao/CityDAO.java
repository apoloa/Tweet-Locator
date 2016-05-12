package com.adrianpolo.twlocator.model.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.adrianpolo.twlocator.model.City;
import com.adrianpolo.twlocator.model.db.DBConstants;

public class CityDAO extends GenericDAO<City> {

    @Override
    protected String getTableName() {
        return DBConstants.TABLE_CITY;
    }

    @Override
    protected String getIdRepresentativeValue() {
        return DBConstants.KEY_CITY_ID;
    }

    @Override
    protected ContentValues getContentValues(City city) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.KEY_CITY_NAME, city.getCity());
        contentValues.put(DBConstants.KEY_CITY_LATITUDE, city.getLatitude());
        contentValues.put(DBConstants.KEY_CITY_LONGITUDE, city.getLongitude());
        return contentValues;
    }

    @Override
    protected String[] getAllColums() {
        return DBConstants.TABLE_CITY_ALL_COLUMNS;
    }

    @NonNull
    @Override
    protected City elementFromCursor(@NonNull Cursor c) {
        assert c != null;

        long id = c.getLong(c.getColumnIndex(DBConstants.KEY_CITY_ID));
        String name = c.getString(c.getColumnIndex(DBConstants.KEY_CITY_NAME));
        Double latitude = c.getDouble(c.getColumnIndex(DBConstants.KEY_TWEET_LATITUDE));
        Double longitude = c.getDouble(c.getColumnIndex(DBConstants.KEY_TWEET_LONGITUDE));

        City city = new City(name, latitude, longitude);

        city.setId(id);

        return city;
    }

    public City findByName(String name) {
        City city = null;

        String where = DBConstants.KEY_CITY_NAME + "='" + name + "'";
        Cursor cursor = db.getReadableDatabase().query(getTableName(), getAllColums(), where, null, null, null, null, "1");
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                city = elementFromCursor(cursor);
            }
            cursor.close();
        }

        return city;
    }
}

