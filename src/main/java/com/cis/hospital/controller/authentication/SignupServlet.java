package com.cis.hospital.controller.authentication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignupPage")
public class SignupServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public SignupServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        handleRequestForLogin(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    private void handleRequestForLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/authentication/signup.jsp");
        dispatcher.forward(req, resp);
        //req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
}
