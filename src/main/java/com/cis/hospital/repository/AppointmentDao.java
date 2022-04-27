package com.cis.hospital.repository;

import com.cis.hospital.model.Appointment;
import com.cis.hospital.utility.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AppointmentDao {
	Connection connection = null;

	public List<Appointment> getUserAppointments(int userID) throws SQLException, ClassNotFoundException {
		List<Appointment> userAppointments = new ArrayList<Appointment>();
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from appointments where UserID="+userID);  
		while(rs.next()) {
			Appointment appointment = new Appointment();
			appointment.setAppointmentID(rs.getInt(1));
			appointment.setUserID(rs.getInt(2));
			appointment.setDoctorID(rs.getInt(3));
			appointment.setVisitors(rs.getInt(4));
			appointment.setAppointmentDate(rs.getDate(5).toString());
			appointment.setDepartment(rs.getString(6));
			appointment.setDoctorName(rs.getString(7));
			
			userAppointments.add(appointment);
		}
		connection.close();
		return userAppointments;
	}
	
	public Appointment getAppointmentById(int id) throws SQLException, ClassNotFoundException {
		Appointment appointment = new Appointment();
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs=stmt.executeQuery("select * from appointments where AppointmentID="+id);  
		while(rs.next()) {			
			appointment.setAppointmentID(rs.getInt(1));
			appointment.setUserID(rs.getInt(2));
			appointment.setDoctorID(rs.getInt(3));
			appointment.setVisitors(rs.getInt(4));
			appointment.setAppointmentDate(rs.getDate(5).toString());
			appointment.setDepartment(rs.getString(6));
			appointment.setDoctorName(rs.getString(7));
		}
		connection.close();
		return appointment;
	}
	
	public String insertAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
		String status = "";
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "INSERT INTO appointments (UserID,DoctorID,visitors,AppointmentDate,Department,DoctorName) VALUES("+appointment.getUserID()+","+appointment.getDoctorID()+","+appointment.getVisitors()+ ",'" +appointment.getAppointmentDate()+ "','" +appointment.getDepartment()+ "','" +appointment.getDoctorName()+ "')";
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	
	
	public String updateAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
		String status;
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "UPDATE appointments SET visitors="+appointment.getVisitors()+", AppointmentDate="+appointment.getAppointmentDate()+ ", Department='" +appointment.getDepartment()+ "'";
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	
	public String deleteAppointment(int appointmentID) throws SQLException, ClassNotFoundException {
		String status;
		connection = DBConnection.createDBConnection();
		Statement stmt = connection.createStatement();
		String sql = "DELETE FROM appointments where AppointmentID="+appointmentID;
		int count = stmt.executeUpdate(sql);
		if(count==1) {
			status = "success";			
		}
		else {
			status = "fail";
		}
		return status;
	}
	

}
