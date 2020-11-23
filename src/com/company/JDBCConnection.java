package com.company;
/*
*   Written By Everyone on 23.11.20
*/

import java.sql.*;

public abstract class JDBCConnection {
    public static java.sql.Connection con = null;

    public static void setup() throws SQLException {
        String url = "jdbc:mysql://localhost/world";
        String user = "java";
        String pw = "java";
        try {
            con = DriverManager.getConnection(url, user, pw);
            System.out.println("Connection succeeded!");
        } catch (SQLException e) {
            System.out.println("Could not connect.");
            e.printStackTrace();
        }
    }
    
    public PreparedStatement prepare(String str) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(str);
        } catch (SQLException e){
            System.out.println("Statement could not be prepared = " + str);
            e.printStackTrace();
        }
        return stmt;
    }
}
