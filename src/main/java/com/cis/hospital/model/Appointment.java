package com.cis.hospital.model;

public class Appointment {

    private int appointmentID;
    private int userID;
    private int doctorID;
    private String doctorName;
    private int visitors;
    private String appointmentDate;
    private String department;

    public Appointment() { }

    public Appointment(int appointmentID, int userID, int doctorID, String doctorName, int visitors, String appointmentDate, String department) {
        this.appointmentID = appointmentID;
        this.userID = userID;
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.visitors = visitors;
        this.appointmentDate = appointmentDate;
        this.department = department;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
