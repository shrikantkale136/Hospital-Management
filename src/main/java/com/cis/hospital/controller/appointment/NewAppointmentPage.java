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

import com.cis.hospital.repository.DoctorDao;


/**
 * Servlet implementation class NewAppointmentPage
 */
@WebServlet("/NewAppointmentPage")
public class NewAppointmentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAppointmentPage() {
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
			handleRequestForNewAppointmentPage(request, response);
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

	
private void handleRequestForNewAppointmentPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		
		DoctorDao doctorDao = new DoctorDao();
		List<String> availableDates = doctorDao.getAvailableDates(Integer.parseInt(request.getParameter("doctorID")));
		request.setAttribute("userID", request.getParameter("userID"));
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("doctorID", request.getParameter("doctorID"));
		request.setAttribute("doctorName", request.getParameter("doctorName"));
		request.setAttribute("availableDates", availableDates);
		request.setAttribute("selectedDate", "");
		request.setAttribute("selectedNo", "");
		request.setAttribute("selectedType", "");
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/appointment/book-appointment.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
