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

import com.cis.hospital.model.Doctor;
import com.cis.hospital.repository.DoctorDao;

/**
 * Servlet implementation class ViewDoctors
 */
@WebServlet("/ViewDoctors")
public class ViewDoctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DoctorDao doctordao = new DoctorDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDoctors() {
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
			handleRequestForViewDoctors(request, response);
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

private void handleRequestForViewDoctors(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		List<Doctor> doctors = doctordao.getDoctorsByCity(request.getParameter("city"));
		request.setAttribute("doctors", doctors);
		request.setAttribute("userID", request.getParameter("userID"));		
		request.setAttribute("username", request.getParameter("username"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/appointment/view-doctors.jsp");
		dispatcher.forward(request, response);
	}
}
