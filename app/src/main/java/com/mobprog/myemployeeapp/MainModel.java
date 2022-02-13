package com.mobprog.myemployeeapp;

import java.util.ArrayList;

public class MainModel {

    public Integer statCode;
    public String NIMMhs;
    public String NamaMhs;
    public String credits;
    public ArrayList<Employee> employeesAL;

    public static class Employee{
        public int employeeID;
        public String employeeGender;
        public EmployeeName employeeName;
        public EmployeeLocation employeeLocation;
        public String employeeEmail;
        public LoginStatus loginStatus;
        public DateOfBirth employeeDoB;
        public RegisterDate employeeRegDate;
        public Integer phoneNum;
        public Integer cellNum;
        public EmployeeID id;
        public EmployeePicture employeePic;
        public String nat;
    }

    public ArrayList<Employee> getEmployeesAL() {
        return employeesAL;
    }

    public void setEmployeesAL(ArrayList<Employee> employeesAL) {
        this.employeesAL = employeesAL;
    }
}
