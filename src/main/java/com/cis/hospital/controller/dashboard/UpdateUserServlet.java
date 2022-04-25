package com.cis.hospital.controller.dashboard;

import com.cis.hospital.model.UserLogin;
import com.cis.hospital.repository.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDAO = new UserDao();

    public UpdateUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            handleRequestForUpdateUser(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void handleRequestForUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserLogin user = new UserLogin();
        user.setUserName(request.getParameter("username"));
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setMobileNumber(request.getParameter("mobileNumber"));
        user.setAddress(request.getParameter("address"));
        user.setCity(request.getParameter("city"));

        RequestDispatcher dispatcher;
        request.setAttribute("user", user);
        String status = userDAO.updateUser(user);
        if(status == "SUCCESS") {
            dispatcher = request.getRequestDispatcher("views/dashboard/user-home.jsp");
        }
        else {
            dispatcher = request.getRequestDispatcher("views/error/fail.jsp");
        }
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("userID", request.getParameter("userID"));
        dispatcher.forward(request, response);
    }
}
