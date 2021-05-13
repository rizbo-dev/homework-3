package com.example.projekat_3_boris_evetovic;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double lat;
    Double lng;
    String intentChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent i = getIntent();
         intentChoice = i.getStringExtra("choice");
        if (intentChoice.contains("vts")) {
          lat = 46.094540847552935;
          lng = 19.662150274467027;
        }
        if (intentChoice.contains("kizur")) {
            lat = 46.10511689420695;
            lng = 19.666108307465546;
        }
        if (intentChoice.contains("tsis")) {
            lat = 46.0976461979938;
            lng = 19.67123596027407;
        }
        if (intentChoice.contains("velebit")) {
            lat = 46.00858275145908;
            lng = 19.89897070623818;
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng vts = new LatLng(lat, lng);
        Marker marker = mMap.addMarker(new MarkerOptions().position(vts).title(intentChoice));
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vts));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vts,18));
    }
}