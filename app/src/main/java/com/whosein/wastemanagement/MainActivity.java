package com.whosein.wastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int NUM_MARKERS = 25;
    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    



    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;
        LatLng baku = new LatLng(40.4093, 49.8671);
        float zoomLevel = 12.0f; // Set your desired default zoom level here

        myMap.addMarker(new MarkerOptions().position(baku).title("Baku"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(baku, zoomLevel));

        double latRange = 0.02;
        double lngRange = 0.02;

        Random random = new Random();

        for (int i = 0; i < NUM_MARKERS; i++) {
            double lat = baku.latitude + (Math.random() - 0.0000005) * latRange;
            double lng = baku.longitude + (Math.random() - 0.0000005) * lngRange;

            LatLng markerPosition = new LatLng(lat, lng);
            int hours = random.nextInt(24);
            int minutes = random.nextInt(60);
            String randomTime = String.format("%02d:%02d", hours, minutes);
            myMap.addMarker(new MarkerOptions().position(markerPosition).title("XX-XX-XXX " + randomTime));
        }
    }


    public void profile(View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

}