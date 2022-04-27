package com.cis.hospital.controller.appointment;

import com.cis.hospital.repository.DoctorDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewDepartments
 */
@WebServlet("/ViewCities")
public class ViewCities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DoctorDao doctordao = new DoctorDao();
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCities() {
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
			handleRequestForViewCities(request, response);
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
	
	private void handleRequestForViewCities(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		List<String> cities = doctordao.getCities();
		request.setAttribute("cities", cities);
		request.setAttribute("selected", "");
		request.setAttribute("userID", request.getParameter("userID"));
		request.setAttribute("username", request.getParameter("username"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/appointment/view-cities.jsp");
		dispatcher.forward(request, response);
	}

}
