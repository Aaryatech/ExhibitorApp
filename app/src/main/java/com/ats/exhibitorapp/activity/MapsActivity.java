package com.ats.exhibitorapp.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.adapter.RouteListAdapter;
import com.ats.exhibitorapp.model.RouteDetails;
import com.ats.exhibitorapp.utils.DirectionsJSONParser;
import com.ats.exhibitorapp.utils.ItemDecorator;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private RecyclerView rvRouteList;
    List<RouteDetails> routeDetailses1 = new ArrayList<>();
    private final double degreesPerRadian = 180.0 / Math.PI;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        rvRouteList = findViewById(R.id.rvRouteList);
        ivBack = findViewById(R.id.ivBack);
        routeDetailses1 = new ArrayList<>();

        RouteDetails routeDetails10 = new RouteDetails();
        routeDetails10.setStopName("CBS");
        routeDetails10.setLatLng(new LatLng(20.000649, 73.782144));
        routeDetails10.setTime("11:00 AM");
        routeDetailses1.add(routeDetails10);

        RouteDetails routeDetails11 = new RouteDetails();
        routeDetails11.setStopName("Sharanpur Road");
        routeDetails11.setLatLng(new LatLng(20.001006, 73.776900));
        routeDetails11.setTime("12:25 PM");
        routeDetailses1.add(routeDetails11);

        RouteDetails routeDetails12 = new RouteDetails();
        routeDetails12.setStopName("Tidke Colony");
        routeDetails12.setLatLng(new LatLng(19.989870, 73.772373));
        routeDetails12.setTime("2.20 PM");
        routeDetailses1.add(routeDetails12);

        RouteDetails routeDetails13 = new RouteDetails();
        routeDetails13.setLatLng(new LatLng(20.011978, 73.756096));
        routeDetails13.setStopName("Jehan Circle");
        routeDetails13.setTime("5.30 PM");
        routeDetailses1.add(routeDetails13);


        RouteListAdapter routeListAdapter = new RouteListAdapter(routeDetailses1, getApplicationContext(), MapsActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        ItemDecorator itemDecorator = new ItemDecorator(-12);

        rvRouteList.setLayoutManager(mLayoutManager);
        rvRouteList.setItemAnimator(new DefaultItemAnimator());
        rvRouteList.addItemDecoration(itemDecorator);
        rvRouteList.setAdapter(routeListAdapter);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = null;


        for (int i = 0; i < routeDetailses1.size(); i++) {

            if (i != routeDetailses1.size() - 1) {
                String url = getDirectionsUrl(routeDetailses1.get(i).getLatLng(), routeDetailses1.get(i + 1).getLatLng());

                DownloadTask downloadTask = new DownloadTask();

                downloadTask.execute(url);

            }

            location = new LatLng(routeDetailses1.get(i).getLatLng().latitude, routeDetailses1.get(i).getLatLng().longitude);

            String name= getAddressByLatLong(routeDetailses1.get(i).getLatLng().latitude, routeDetailses1.get(i).getLatLng().longitude);
            mMap.addMarker(new MarkerOptions().position(location).title(name).snippet(routeDetailses1.get(i).getTime()));

        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);

    }

    private String getAddressByLatLong(double latitude, double longitude) {

        try {

            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(this, Locale.getDefault());

            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            String address = addresses.get(0).getAddressLine(0);
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
            return address;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        String sensor = "sensor=false";

        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }


    @SuppressLint("LongLogTag")
    private String downloadUrl(String strUrl) throws IOException {

        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;

        try {

            URL url = new URL(strUrl);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downloading url", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }


    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {


            String data = "";

            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            parserTask.execute(result);
        }
    }


    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            try {

                for (int i = 0; i < result.size(); i++) {
                    points = new ArrayList<LatLng>();
                    lineOptions = new PolylineOptions();

                    List<HashMap<String, String>> path = result.get(i);

                    for (int j = 0; j < path.size(); j++) {
                        HashMap<String, String> point = path.get(j);

                        double lat = Double.parseDouble(point.get("lat"));
                        double lng = Double.parseDouble(point.get("lng"));
                        LatLng position = new LatLng(lat, lng);

                        points.add(position);
                    }

                    lineOptions.addAll(points);
                    lineOptions.width(10);
                    lineOptions.color(Color.RED);
                }

                mMap.addPolyline(lineOptions);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}
