package com.mobprog.myemployeeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmployeeDetail extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gmaps;
    Double latitude, longitude;
    TextView addBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_detail_activity);

        addBtn = findViewById(R.id.addto_address);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //nambahin data ke arraylist baru

                Intent movetoMainAct = new Intent(EmployeeDetail.this, MainActivity.class);

                Intent savingData = new Intent(EmployeeDetail.this, SavedAddressFragment.class);
                movetoMainAct.putExtra("photo", (getIntent().getExtras().getString("photo")));
                movetoMainAct.putExtra("name", (getIntent().getExtras().getString("name")));
                movetoMainAct.putExtra("city", (getIntent().getExtras().getString("city")));
                movetoMainAct.putExtra("phone", (getIntent().getExtras().getString("phone")));
                movetoMainAct.putExtra("email", (getIntent().getExtras().getString("email")));

                Log.i("Name", getIntent().getExtras().getString("name"));
                Log.i("City", getIntent().getExtras().getString("city"));
                Log.i("phone", getIntent().getExtras().getString("phone"));
                Log.i("email", getIntent().getExtras().getString("email"));

                startActivity(movetoMainAct);
            }
        });

        //change date format
        String registDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        try {
            Date date = (Date) format.parse(getIntent().getExtras().getString("registered"));
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
            registDate = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //displayed datas
        TextView nameDetail = findViewById(R.id.name_detail);
        TextView cityDetail = findViewById(R.id.city_detail);
        TextView phoneDetail = findViewById(R.id.phone_detail);
        TextView memberDetail = findViewById(R.id.regist_detail);
        TextView emailDetail = findViewById(R.id.email_detail);


        nameDetail.setText(getIntent().getExtras().getString("name"));
        cityDetail.setText("City : " + getIntent().getExtras().getString("city"));
        phoneDetail.setText("Phone : " + getIntent().getExtras().getString("phone"));
        memberDetail.setText("Member since : " + registDate);
        emailDetail.setText("Email : " + getIntent().getExtras().getString("email"));

        latitude = Double.parseDouble(getIntent().getExtras().getString("latitude"));
        longitude = Double.parseDouble(getIntent().getExtras().getString("longitude"));


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
