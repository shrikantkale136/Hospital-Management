package com.cis.hospital.controller.dashboard;

import com.cis.hospital.model.UserLogin;
import com.cis.hospital.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserDetails")
public class UserDetailsServlet extends HttpServlet {
    UserDao userDAO = new UserDao();

    public UserDetailsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForUserDetails(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void handleRequestForUserDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserLogin user = userDAO.getUser(request.getParameter("username"));
        request.setAttribute("user", user);
        request.getRequestDispatcher("views/dashboard/user-details.jsp").forward(request, response);
    }

}

