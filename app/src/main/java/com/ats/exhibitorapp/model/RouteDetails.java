package com.ats.exhibitorapp.model;

import com.google.android.gms.maps.model.LatLng;


public class RouteDetails {
    private String stopName,time;
    private LatLng latLng;

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    @Override
    public String toString() {
        return "RouteDetails{" +
                "stopName='" + stopName + '\'' +
                ", time='" + time + '\'' +
                ", latLng=" + latLng +
                '}';
    }
}
