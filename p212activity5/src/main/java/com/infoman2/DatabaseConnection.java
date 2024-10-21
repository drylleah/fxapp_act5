package com.infoman2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost:3340/p212_activity5";
    private String user = "app";
    private String password = "1234";

    public Connection connection;

    public DatabaseConnection(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
