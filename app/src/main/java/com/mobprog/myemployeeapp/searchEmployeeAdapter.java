package com.mobprog.myemployeeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class searchEmployeeAdapter extends RecyclerView.Adapter<searchEmployeeAdapter.EmployeeViewHolder> {
    private ArrayList<MainModel.Employee> employeeAL;
    private RecyclerViewClickListener listener;

    public searchEmployeeAdapter(ArrayList<MainModel.Employee> employeeAL, RecyclerViewClickListener listener) {
        this.employeeAL = employeeAL;
        this.listener = listener;
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView employeeNameText, employeeCity, employeePhone, employeeRegistered;
        private ImageView imageView;

        public EmployeeViewHolder(final View itemView) {
            super(itemView);
            employeeNameText = itemView.findViewById(R.id.emp_name);
            employeeCity = itemView.findViewById(R.id.emp_city);
            employeePhone = itemView.findViewById(R.id.emp_phone);
            employeeRegistered = itemView.findViewById(R.id.emp_registed);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_recycler_layout, parent, false);
        return new EmployeeViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull searchEmployeeAdapter.EmployeeViewHolder holder, int position) {
        Picasso.get().load(employeeAL.get(position).picture.thumbnail).into(holder.imageView);
        holder.employeeNameText.setText(String.format("%s %s", employeeAL.get(position).employeeName.first, employeeAL.get(position).employeeName.last));
        holder.employeeCity.setText(String.format("City : %s, %s", employeeAL.get(position).employeeLocation.city, employeeAL.get(position).employeeLocation.country));
        holder.employeePhone.setText(String.format("Phone : %s / %s", employeeAL.get(position).phone, employeeAL.get(position).cell));
        holder.employeeRegistered.setText(String.format("Registered Date : %s", employeeAL.get(position).registered.date));
    }

    @Override
    public int getItemCount() {
        return employeeAL.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

}
