package com.cis.hospital.repository;

import com.cis.hospital.model.UserLogin;
import com.cis.hospital.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection = null;

    public List<UserLogin> getUsers() throws SQLException, ClassNotFoundException {
        List<UserLogin> users = new ArrayList<UserLogin>();
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("select * from users");
        while(rs.next()) {
            UserLogin user = new UserLogin();
            user.setUserID(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setFirstName(rs.getString(3));
            user.setLastName(rs.getString(4));
            user.setAge(rs.getInt(5));
            user.setMobileNumber(rs.getString(6));
            user.setAddress(rs.getString(7));
            user.setCity(rs.getString(8));
            users.add(user);
        }
        connection.close();
        return users;
    }


    public UserLogin getUser(String userName) throws SQLException, ClassNotFoundException {
        UserLogin user = new UserLogin();
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from users where userName = '"+userName+"'");
        while(rs.next()){
            user.setUserID(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setFirstName(rs.getString(4));
            user.setLastName(rs.getString(5));
            user.setAge(rs.getInt(6));
            user.setMobileNumber(rs.getString(7));
            user.setAddress(rs.getString(8));
            user.setCity(rs.getString(9));
        }
        return user;
    }



    public String insertUser(UserLogin user) throws SQLException, ClassNotFoundException {
        String status = "";
        UserLogin userDB = getUser(user.getUserName());
        if(userDB.getUserName()==null) {
            connection = DBConnection.createDBConnection();
            String query = "INSERT INTO users(userID, userName,password,firstName,lastName,age,mobileNumber,address,city) VALUES (NULL,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setInt(5, user.getAge());
            stmt.setString(6, user.getMobileNumber());
            stmt.setString(7, user.getAddress());
            stmt.setString(8, user.getCity());

            stmt.executeUpdate();
            status = "SUCCESS";
        }
        else {
            status = "FAIL";
        }
        return status;
    }



    public String updateUser(UserLogin user) throws SQLException, ClassNotFoundException {
        String status;
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        String sql = "UPDATE USERS SET FirstName=\'"+user.getFirstName()+"\', LastName=\'"+user.getLastName()+"\', Age=\'"+user.getAge()+"\', MobileNumber=\'"+user.getMobileNumber()+"\', Address=\'"+user.getAddress()+"\', City=\'"+user.getCity()+"\' where UserName=\'"+user.getUserName()+"\'";
        int count = stmt.executeUpdate(sql);
        if(count==1) {
            status = "SUCCESS";
            System.out.println("SUCCESS : Record updated successfully for user " + user.getUserName());
        }
        else {
            status = "FAIL";
            System.out.println("FAIL : Record unable to update for user " + user.getUserName());
        }
        return status;
    }
}
