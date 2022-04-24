package com.cis.hospital.model;

public class Doctor {
    private int doctorID;
    private String doctorName;
    private String city;
    private String address;
    private int cost;
    private float rating;

    public Doctor() {
    }

    public Doctor(int doctorID, String doctorName, String city, String address, int cost, float rating) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.city = city;
        this.address = address;
        this.cost = cost;
        this.rating = rating;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
