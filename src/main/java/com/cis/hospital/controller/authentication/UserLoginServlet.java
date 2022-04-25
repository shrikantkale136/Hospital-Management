package com.cis.hospital.controller.authentication;

import com.cis.hospital.model.UserLogin;
import com.cis.hospital.repository.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginUser")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserDao userDAO = new UserDao();

    public UserLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForLoginUserdoGet(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void handleRequestForLoginUserdoGet(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String result = "";

        UserLogin user = userDAO.getUser(req.getParameter("username"));

        if(user.getUserName() != null) {
            if(user.getPassword().equals(req.getParameter("password"))) {
                result = "User Authenticated";
                req.setAttribute("userID", user.getUserID());
                req.setAttribute("username", req.getParameter("username"));
                req.getRequestDispatcher("views/dashboard/user-home.jsp").forward(req, resp);
            }
            else {
                result = "Username or Password is incorrect";
                req.setAttribute("result", result);
                req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
            }
        }
        else {
            result = "User Does not exist";
            req.setAttribute("result", result);
            req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
        }
    }
}
