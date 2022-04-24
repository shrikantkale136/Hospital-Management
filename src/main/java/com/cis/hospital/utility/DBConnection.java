package com.cis.hospital.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection createDBConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
        final String USERNAME = "root";
        final String PASSWORD = "gismaster";
        Connection con = null;
        try{
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Success");
        }catch (SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
