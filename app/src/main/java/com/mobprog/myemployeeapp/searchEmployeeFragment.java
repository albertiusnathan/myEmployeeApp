package com.mobprog.myemployeeapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    ArrayList<MainModel.Employee> employeesAL = new ArrayList();
    private searchEmployeeAdapter.RecyclerViewClickListener listener;
    View view;
    RecyclerView employeeRV;
    Button searchBtn;
    EditText inputArea;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_search_employee, container, false);
        employeeRV = view.findViewById(R.id.rc_employeelist);
        employeeRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        employeeRV.setItemAnimator(new DefaultItemAnimator());

        inputArea = view.findViewById(R.id.et_employee);
        searchBtn = view.findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), inputArea.getText().toString(), Toast.LENGTH_SHORT).show();
                //search
            }
        });

        getDatafromAPI();
        return view;
    }

    private void setOnClickListener() {
        listener = new searchEmployeeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getContext(), EmployeeDetail.class);
                intent.putExtra("photo", (employeesAL.get(position).picture.thumbnail));
                intent.putExtra("name", (employeesAL.get(position).employeeName.first+ " " + employeesAL.get(position).employeeName.last));
                intent.putExtra("city", (employeesAL.get(position).employeeLocation.city+ ", " + employeesAL.get(position).employeeLocation.country));
                intent.putExtra("phone", (employeesAL.get(position).cell+ " / " + employeesAL.get(position).phone));
                intent.putExtra("registered", (employeesAL.get(position).registered.date));
                intent.putExtra("email", (employeesAL.get(position).email));
                intent.putExtra("latitude", (employeesAL.get(position).employeeLocation.coordinates.latitude));
                intent.putExtra("longitude", (employeesAL.get(position).employeeLocation.coordinates.longitude));
                startActivity(intent);
            }
        };
    }

    private void getDatafromAPI(){
        APIService.apiEnd().getEmployeesAL().enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                setOnClickListener();
                employeesAL = response.body().getEmployeesAL();
                employeeRV.setAdapter(new searchEmployeeAdapter(employeesAL, listener));
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                Log.e("EmployeeAPI", "Failed to connect the API...", t);
            }
        });
    }

}