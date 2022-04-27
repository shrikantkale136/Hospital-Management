package com.cis.hospital.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cis.hospital.model.Doctor;
import com.cis.hospital.utility.DBConnection;

public class DoctorDao {
	Connection connection = null;

	public List<Doctor> getDoctorsByCity(String city) throws SQLException, ClassNotFoundException {

	List<Doctor> doctors = new ArrayList<Doctor>();
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from doctors where City='" +city+ "'");
		while(rs.next()) {
			Doctor doctorr = new Doctor();
			doctorr.setDoctorID(rs.getInt(1));
			doctorr.setDoctorName(rs.getString(2));
			doctorr.setCity(rs.getString(3));
			doctorr.setAddress(rs.getString(4));
			doctorr.setCost(rs.getInt(5));
			doctorr.setRating(rs.getFloat(6));
			doctors.add(doctorr);
		}
				
		return doctors;
	}
	
	public Doctor getDoctor(int id) throws SQLException, ClassNotFoundException {
		
		Doctor doctorr = new Doctor();
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from doctors where DoctorID="+id);  
		while(rs.next()) {			
			doctorr.setDoctorID(rs.getInt(1));
			doctorr.setDoctorName(rs.getString(2));
			doctorr.setCity(rs.getString(3));
			doctorr.setAddress(rs.getString(4));
			doctorr.setCost(rs.getInt(5));
			doctorr.setRating(rs.getFloat(6));			
		}
				
		return doctorr;
	 	
	}
	
	public List<String> getCities() throws SQLException, ClassNotFoundException {
		
		List<String> cities = new ArrayList<String>();
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select distinct city from doctors");  
		while(rs.next()) {
			cities.add(rs.getString(1));
		}
		return cities;
	}

	public List<String> getAvailableDates(int doctorId) throws SQLException, ClassNotFoundException {
		
		List<String> availableDates = new ArrayList<String>();
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select AvailableDate from doctor_availability where DoctorID="+doctorId);  
		while(rs.next()) {
			availableDates.add(rs.getString(1));
		}
		return availableDates;
	}
	

}
