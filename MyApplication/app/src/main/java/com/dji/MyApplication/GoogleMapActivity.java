package com.dji.MyApplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap gMap;
    private double DroneLocationLat = 0, DroneLocationLng = 0;
    private Marker droneMarker = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.googlemap);
        Intent intent = new Intent(this.getIntent());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // TODO Auto-generated method stub
        // Initializing Amap object
        gMap = googleMap;

        LatLng suniv = new LatLng(36.833558, 127.179065);
        gMap.addMarker(new MarkerOptions().position(suniv).title("suniv"));

        gMap.moveCamera(CameraUpdateFactory.newLatLng(suniv));
        DroneLocationLat = getIntent().getExtras().getDouble("lat");
        DroneLocationLng = getIntent().getExtras().getDouble("lang");

        LatLng drone_current_position = new LatLng(DroneLocationLat,DroneLocationLng);
        gMap.addMarker(new MarkerOptions().position(drone_current_position).title("dronecurrentposition"));
    }
}
