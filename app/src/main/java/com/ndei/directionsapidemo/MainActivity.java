package com.ndei.directionsapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng Craft = new LatLng(-1.2644976319583467, 36.76338603886449);
        LatLng Nairobi = new LatLng(-1.2788919462455774, 36.8231447736811);
        googleMap.addMarker(
                new MarkerOptions()
                        .position(Nairobi)
                        .title("Nairobi")
        );
        googleMap.addMarker(
                new MarkerOptions()
                        .position(Craft)
                        .title("Craft Silicon LTD")
        );
        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                LatLngBounds bound = new LatLngBounds.Builder()
                        .include(Craft)
                        .include(Nairobi)
                        .build();

                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bound, 30));
            }
        });
    }
}