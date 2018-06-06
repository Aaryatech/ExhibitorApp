package com.ats.exhibitorapp.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ATS on 01/05/17.
 */

public class MapData {

    private LatLng busCurrentLoc,nextStop,userLocation;

    public LatLng getBusCurrentLoc() {
        return busCurrentLoc;
    }

    public void setBusCurrentLoc(LatLng busCurrentLoc) {
        this.busCurrentLoc = busCurrentLoc;
    }

    public LatLng getNextStop() {
        return nextStop;
    }

    public void setNextStop(LatLng nextStop) {
        this.nextStop = nextStop;
    }

    public LatLng getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(LatLng userLocation) {
        this.userLocation = userLocation;
    }

    @Override
    public String toString() {
        return "MapData{" +
                "busCurrentLoc=" + busCurrentLoc +
                ", nextStop=" + nextStop +
                ", userLocation=" + userLocation +
                '}';
    }
}
