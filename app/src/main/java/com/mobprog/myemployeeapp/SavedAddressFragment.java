package com.mobprog.myemployeeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class SavedAddressFragment extends Fragment {
    View view;
    RecyclerView savedRV;
    Button call, email;
    savedAddressAdapter adapter;

    ArrayList<String> photo =new ArrayList<>();
    ArrayList<String> names =new ArrayList<>();
    ArrayList<String> cities =new ArrayList<>();
    ArrayList<String> phones =new ArrayList<>();
    ArrayList<String> emails =new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_saved_address, container, false);
        savedRV = view.findViewById(R.id.saved_address_rv);
        savedRV.setLayoutManager(new LinearLayoutManager(this.getContext()));
        savedRV.setItemAnimator(new DefaultItemAnimator());

        call = view.findViewById(R.id.sa_callBtn);
        email = view.findViewById(R.id.sa_emailBtn);

        photo.add(getActivity().getIntent().getExtras().getString("photo"));
        names.add(getActivity().getIntent().getExtras().getString("name"));
        cities.add(getActivity().getIntent().getExtras().getString("city"));
        phones.add(getActivity().getIntent().getExtras().getString("phone"));
        emails.add(getActivity().getIntent().getExtras().getString("email"));

        adapter = new savedAddressAdapter(photo, names, cities, phones, emails);
        savedRV.setAdapter(adapter);

        return view;
    }
}