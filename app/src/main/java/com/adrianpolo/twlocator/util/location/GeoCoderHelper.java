package com.adrianpolo.twlocator.util.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoCoderHelper {
    Geocoder geocoder;
    int reintents;

    public GeoCoderHelper(Context context, Locale locale, int reintents) {
        geocoder = new Geocoder(context, locale);
        this.reintents = reintents;
    }


    public String getNameOfCity(LatLng position) {
        for (int i = 0; i < reintents; i++) {
            String result = getNameOfCityFromGeoCoder(position);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public String getNameOfCityFromGeoCoder(LatLng position) {
        try {
            List<Address> addresses = geocoder.
                    getFromLocation(position.latitude, position.longitude, 1);
            Log.d("Addresses", "" + addresses.size());
            if (addresses.size() > 0) {
                Log.d("CountryName", addresses.get(0).getCountryName());
                String cityName = addresses.get(0).getAddressLine(0);
                Log.d("City", addresses.get(0).getLocality());
                return cityName;
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
