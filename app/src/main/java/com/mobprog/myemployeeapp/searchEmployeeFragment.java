package com.mobprog.myemployeeapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobprog.myemployeeapp.Retrofit.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchEmployeeFragment extends Fragment {
    ArrayList<MainModel.Employee> employeesAL;
    View view;
    RecyclerView employeeRV;
    Button searchBtn;
    EditText inputArea;
    searchEmployeeAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDatafromAPI();
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_search_employee, container, false);
         employeeRV = view.findViewById(R.id.rc_employeelist);
         employeeRV.setLayoutManager(new LinearLayoutManager(getContext()));

        inputArea = view.findViewById(R.id.et_employee);

        searchAdapter = new searchEmployeeAdapter(employeesAL);

        searchBtn = view.findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), inputArea.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

         return view;
    }

//    private void setOnClickListener() {
//        listener = new searchEmployeeAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//                Intent intent = new Intent(getContext(), EmployeeDetail.class);
//                intent.putExtra("name", employeesAL.get(position).employeeName.firstName);
//                startActivity(intent);
//            }
//        };
//    }

    private void getDatafromAPI(){
        APIService.apiEnd().getEmployeesAL().enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
               employeesAL = response.body().getEmployeesAL();
                employeeRV.setAdapter(searchAdapter);

            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                Log.e("EmployeeAPI", "Failed to connect the API...", t);
            }
        });
    }

}