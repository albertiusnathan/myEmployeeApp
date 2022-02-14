package com.mobprog.myemployeeapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class savedAddressAdapter extends RecyclerView.Adapter<savedAddressAdapter.SA_ViewHolder> {
    ArrayList<String> photo, name, city, phone, email;

    public savedAddressAdapter(ArrayList<String> photo, ArrayList<String> name, ArrayList<String> city, ArrayList<String> phone, ArrayList<String> email) {
        this.photo = photo;
        this.name = name;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    @NonNull
    @Override
    public SA_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_address_layout, parent, false);
        return new SA_ViewHolder(view);
    }

    
    @Override
    public void onBindViewHolder(@NonNull SA_ViewHolder holder, int position) {
        Picasso.get().load(String.valueOf(photo.get(position))).into(holder.photo);
        holder.sa_name.setText(name.get(position));
        holder.sa_city.setText(city.get(position));
    }


    @Override
    public int getItemCount() {
        return name.size();
    }

    public class SA_ViewHolder extends RecyclerView.ViewHolder{
        TextView sa_name;
        TextView sa_city;
        Button sa_email, sa_call;
        ImageView photo;


        public SA_ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = (ImageView)  itemView.findViewById(R.id.sa_imageView);
            sa_name = (TextView) itemView.findViewById(R.id.sa_emp_name);
            sa_city = (TextView) itemView.findViewById(R.id.sa_emp_city);
            sa_call = itemView.findViewById(R.id.sa_callBtn);
            sa_email = itemView.findViewById(R.id.sa_emailBtn);

        }
    }
}
