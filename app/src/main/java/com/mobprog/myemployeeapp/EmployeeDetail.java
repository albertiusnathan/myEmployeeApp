package com.mobprog.myemployeeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//import androidx.fragment.app.FragmentActivity;

public class EmployeeDetail extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gmaps;
    Double latitude, longitude;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_detail_activity);

        //displayed datas
        TextView nameDetail = findViewById(R.id.name_detail);
        TextView cityDetail = findViewById(R.id.city_detail);
        TextView phoneDetail = findViewById(R.id.phone_detail);
        TextView memberDetail = findViewById(R.id.regist_detail);
        TextView emailDetail = findViewById(R.id.email_detail);


        nameDetail.setText(getIntent().getExtras().getString("name"));
        cityDetail.setText("City : " + getIntent().getExtras().getString("city"));
        phoneDetail.setText("Phone : " + getIntent().getExtras().getString("phone"));
        memberDetail.setText("Member since : " + getIntent().getExtras().getString("registered"));
        emailDetail.setText("Email : " + getIntent().getExtras().getString("email"));

        latitude = getIntent().getExtras().getDouble("latitude");
        longitude = getIntent().getExtras().getDouble("longitude");


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_detail);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gmaps = googleMap;

        LatLng coordinate = new LatLng(latitude, longitude);

        gmaps.addMarker(new MarkerOptions()
                .position(coordinate)
                .title(getIntent().getExtras().getString("city")));
        gmaps.moveCamera(CameraUpdateFactory.newLatLng(coordinate));
    }
}
