package com.mobprog.myemployeeapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobprog.myemployeeapp.Retrofit.APIService;

public class searchEmployeeFragment extends Fragment {

    View view;
    RecyclerView employeeRV;
    Button searchBtn;
    EditText inputArea;
    searchEmployeeAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_search_employee, container, false);
         employeeRV = view.findViewById(R.id.rc_employeelist);
         employeeRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
//         employeeRV.setAdapter();

        inputArea = view.findViewById(R.id.et_employee);

        searchBtn = view.findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), inputArea.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

         return view;
    }

    private void getDatafromAPI(){
//        APIService.apiEnd().get
    }

}