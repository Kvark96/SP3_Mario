package com.company;


import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException, FileNotFoundException {
        JDBCConnection.setup();
        Systems systems = new Systems();
    }
}