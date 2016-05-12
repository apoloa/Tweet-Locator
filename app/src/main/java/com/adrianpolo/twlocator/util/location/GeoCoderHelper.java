package com.adrianpolo.twlocator.util.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

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


    public String getInfoForPosition(LatLng position) {
        for (int i = 0; i < reintents; i++) {
            String identifiers = getNameOfCityFromGeoCoder(position);
            if (identifiers != null) {
                return identifiers;
            }
        }
        return null;
    }

    public String getNameOfCityFromGeoCoder(LatLng position) {
        try {
            List<Address> addresses = geocoder.
                    getFromLocation(position.latitude, position.longitude, 1);
            if (addresses.size() > 0) {
                return addresses.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public LatLng getLatLngFromName(String name){
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocationName(name, 1);
            if (addresses.size() > 0) {
                return new LatLng(addresses.get(0).getLatitude(),addresses.get(0).getLongitude());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
