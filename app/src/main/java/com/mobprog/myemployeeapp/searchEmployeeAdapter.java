package com.mobprog.myemployeeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class searchEmployeeAdapter extends RecyclerView.Adapter<searchEmployeeAdapter.EmployeeViewHolder> {
    private ArrayList<MainModel.Employee> employeeAL;
    private RecyclerViewClickListener recyclerListener;

    public searchEmployeeAdapter(ArrayList<MainModel.Employee> employeeAL/*, RecyclerViewClickListener recyclerListener*/) {
        this.employeeAL = employeeAL;
//        this.recyclerListener = recyclerListener;
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder{
        private TextView employeeNameText, employeeCity, employeePhone, employeeRegistered;
        private ImageView imageView;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeNameText = itemView.findViewById(R.id.emp_name);
            employeeCity = itemView.findViewById(R.id.emp_city);
            employeePhone = itemView.findViewById(R.id.emp_phone);
            employeeRegistered = itemView.findViewById(R.id.emp_registed);
            imageView = itemView.findViewById(R.id.imageView);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            recyclerListener.onClick(view, getAdapterPosition());
//
//        }
    }

    @NonNull
    @Override
    public searchEmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_recycler_layout, parent, false);
        return new EmployeeViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull searchEmployeeAdapter.EmployeeViewHolder holder, int position) {
        holder.imageView.setImageURI(employeeAL.get(position).employeePic.thumbnail);
        holder.employeeNameText.setText(String.format("%s%s", employeeAL.get(position).employeeName.firstName, employeeAL.get(position).employeeName.lastName));
        holder.employeeCity.setText(String.format("City : %s, %s", employeeAL.get(position).employeeLocation.cityName, employeeAL.get(position).employeeLocation.countryName));
        holder.employeePhone.setText(String.format("Phone : %d / %d", employeeAL.get(position).phoneNum, employeeAL.get(position).cellNum));
        holder.employeeRegistered.setText(String.format("Registered Date : %s", employeeAL.get(position).employeeRegDate.date));
    }

    @Override
    public int getItemCount() {
        return employeeAL.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

}
