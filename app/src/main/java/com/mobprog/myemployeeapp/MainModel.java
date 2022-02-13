package com.mobprog.myemployeeapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainModel {

    public Integer statusCode;
    public String nim;
    public String nama;
    public String credits;
    @SerializedName("employees")
    public ArrayList<Employee> employeesAL;

    public static class Employee{
        public int employeeId;
        public String gender;
        @SerializedName("name")
        public EmployeeName employeeName;
        @SerializedName("location")
        public EmployeeLocation employeeLocation;
        public String email;
        public LoginStatus login;
        public DateOfBirth dob;
        public RegisterDate registered;
        public String phone;
        public String cell;
        public EmployeeID id;
        public EmployeePicture picture;
        public String nat;
    }

    public ArrayList<Employee> getEmployeesAL() {
        return employeesAL;
    }

    public void setEmployeesAL(ArrayList<Employee> employeesAL) {
        this.employeesAL = employeesAL;
    }
}
