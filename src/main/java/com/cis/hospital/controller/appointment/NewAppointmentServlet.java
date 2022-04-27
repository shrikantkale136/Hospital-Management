package com.cis.hospital.controller.appointment;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cis.hospital.model.Appointment;
import com.cis.hospital.repository.AppointmentDao;

@WebServlet("/NewAppointment")
public class NewAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentDao appointmentDAO = new AppointmentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			handleRequestForNewAppointment(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
private void handleRequestForNewAppointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException, ClassNotFoundException {
		
	String userID = request.getParameter("userID");
		String doctorID = request.getParameter("doctorID");
		String visitors = request.getParameter("visitors");
		int id = Integer.parseInt(userID);
		System.out.println("ID: "+id);
		
		Appointment appointment = new Appointment();
		appointment.setUserID(Integer.parseInt(userID));
		appointment.setDoctorID(Integer.parseInt(doctorID));		
		appointment.setVisitors(Integer.parseInt(visitors));
		appointment.setDepartment(request.getParameter("department"));
		appointment.setDoctorName(request.getParameter("doctorName"));

		String appointmentDate =  request.getParameter("appointmentDate");
				
		appointment.setAppointmentDate(appointmentDate);
		String status = appointmentDAO.insertAppointment(appointment);
		RequestDispatcher dispatcher;
		request.setAttribute("userID", userID);
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("departments", request.getParameter("departments"));
		if(status == "success") {
			request.setAttribute("result", "User Appointment Booking Successful for the Doctor: "+ request.getParameter("doctorName") );			
		}
		else {
			request.setAttribute("result", "User Appointment Booking Failed for the Doctor "+request.getParameter("doctorName")+", Please try Again!");			
		}
		dispatcher = request.getRequestDispatcher("views/appointment/user-home.jsp");
		dispatcher.forward(request, response);
	}
}
