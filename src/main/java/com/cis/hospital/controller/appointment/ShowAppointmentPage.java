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
import com.cis.hospital.repository.DoctorDao;

/**
 * Servlet implementation class ShowAppointmentPage
 */
@WebServlet("/ShowAppointmentPage")
public class ShowAppointmentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppointmentDao appointmentDAO = new AppointmentDao();
	DoctorDao doctordao = new DoctorDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAppointmentPage() {
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
			handleRequestForShowAppointmentPage(request, response);
		} catch (SQLException | ClassNotFoundException e) {
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
	
private void handleRequestForShowAppointmentPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		
		String userID = request.getParameter("userID");
		List<Appointment> appointments = appointmentDAO.getUserAppointments(Integer.parseInt(userID));
		
		request.setAttribute("userID", userID);
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("appointments", appointments);

		RequestDispatcher dispatcher = request.getRequestDispatcher("views/appointment/view-appointments.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
