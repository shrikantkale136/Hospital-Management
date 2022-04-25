package com.cis.hospital.controller.dashboard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserHomeServlet", value = "/UserHome")
public class UserHomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UserHomeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        handleRequestForUserHome(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    private void handleRequestForUserHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userID = request.getParameter("userID");

        request.setAttribute("username", username);
        request.setAttribute("userID", userID);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/dashboard/user-home.jsp");
        dispatcher.forward(request, response);
    }
}
