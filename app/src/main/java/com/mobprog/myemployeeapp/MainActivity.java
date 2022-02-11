package com.mobprog.myemployeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    Button searchBtn, employeeMenuBtn, savedAddressesMenuBtn;
    EditText etEmployee;
    RecyclerView rcListEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = findViewById(R.id.search_btn);
        employeeMenuBtn = findViewById(R.id.btn_employee_search);
        savedAddressesMenuBtn = findViewById(R.id.btn_saved_addresses);
        etEmployee = findViewById(R.id.et_employee);
        rcListEmployee = findViewById(R.id.rc_employeelist);
    }
}