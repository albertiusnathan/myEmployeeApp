package com.mobprog.myemployeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mobprog.myemployeeapp.Retrofit.APIEndpoint;
import com.mobprog.myemployeeapp.Retrofit.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    Button employeeMenuBtn, savedAddressesMenuBtn;
    ArrayList<MainModel.Employee> employeeAL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameLayout, new searchEmployeeFragment());
        fm.commit();

        employeeAL = new ArrayList<>();

        employeeMenuBtn = findViewById(R.id.btn_employee_search);
        savedAddressesMenuBtn = findViewById(R.id.btn_saved_addresses);

        employeeMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new searchEmployeeFragment());
            }
        });

        savedAddressesMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new SavedAddressFragment());
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragMgr = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMgr.beginTransaction();
        fragTrans.replace(R.id.frameLayout, fragment);
        fragTrans.commit();
    }
}