package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/w4p1";
        String user = "root";
        String password = "password";

        try(Connection conn = DriverManager.getConnection(url,user,password)){
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student (name, major) VALUES (?, ?)");
            preparedStatement.setString(1, "Aman");
            preparedStatement.setString(2, "MCS" );
            preparedStatement.executeUpdate();
//            System.out.println(resultSet);
            System.out.println("Student added");
//            resultSet.close();
            preparedStatement.close();
        }catch(Exception e){
            System.err.println("Connection failed!");
            System.err.println("Error: " + e.getMessage());
        }
    }
}
