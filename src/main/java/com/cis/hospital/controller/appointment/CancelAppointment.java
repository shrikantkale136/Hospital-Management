package com.cis.hospital.controller.appointment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cis.hospital.model.Appointment;
import com.cis.hospital.repository.AppointmentDao;

/**
 * Servlet implementation class CancelAppointment
 */
@WebServlet("/CancelAppointment")
public class CancelAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentDao appointmentDAO = new AppointmentDao();
       
        public CancelAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			handleRequestForCancelAppointment(request, response);
		} catch (SQLException | ClassNotFoundException e) {
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
	
private void handleRequestForCancelAppointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		
		String result;
		String appointmentID = request.getParameter("appointmentID");
		Appointment cancelledAppointment = appointmentDAO.getAppointmentById(Integer.parseInt(appointmentID));
		
		String doctorName = request.getParameter("doctorName");
		String userID = request.getParameter("userID");
		String username = request.getParameter("username");
		String status = appointmentDAO.deleteAppointment(Integer.parseInt(appointmentID));
		
		if(status == "success") {
			
			result = "Appointment with the Doctor: "+cancelledAppointment.getDoctorName()+" on this date "+cancelledAppointment.getAppointmentDate()+" has been cancelled";
		}
		else {
			result = "Cancellation of Appointment with Doctor: "+cancelledAppointment.getDoctorName()+" on this date "+cancelledAppointment.getAppointmentDate()+" is unsuccessful";
			}
		List<Appointment> appointments = appointmentDAO.getUserAppointments(Integer.parseInt(userID));
		request.setAttribute("appointments", appointments);
		request.setAttribute("userID", userID);
		request.setAttribute("username", username);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/appointment/view-appointments.jsp");
		dispatcher.forward(request, response);		
		
		
	}

}
