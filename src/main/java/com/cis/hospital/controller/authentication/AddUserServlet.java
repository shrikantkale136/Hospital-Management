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

@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {

    UserDao userDAO = new UserDao();

    public AddUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForInsertUser(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    private void handleRequestForInsertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserLogin user = new UserLogin();
        user.setUserName(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setFirstName(req.getParameter("firstname"));
        user.setLastName(req.getParameter("lastname"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setMobileNumber(req.getParameter("mobileNumber"));
        user.setAddress(req.getParameter("address"));
        user.setCity(req.getParameter("city"));

        String result;
        String status = userDAO.insertUser(user);
        if(status == "SUCCESS") {
            result = "User Created Successfully. Please Log in";
        }
        else {
            result = "User Creation Failed. Please Sign up again!";
        }

        req.setAttribute("result", result);
        req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
    }
}
