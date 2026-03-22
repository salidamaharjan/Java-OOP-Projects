package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/w4p1";
        String user = "root";
        String password = "password";

        try(Connection conn = DriverManager.getConnection(url,user,password)){
            // Add student to the DB
//            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student (name, major) VALUES (?, ?)");
//            preparedStatement.setString(1, "Aman");
//            preparedStatement.setString(2, "MCS" );
//            preparedStatement.executeUpdate();
//            System.out.println("Student added");
//            preparedStatement.close();
            PreparedStatement preparedStatement1 = conn.prepareStatement("Select * FROM student");
            ResultSet resultSet = preparedStatement1.executeQuery();
            System.out.println("Name of Students ↓");
            while(resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }
            resultSet.close();
            preparedStatement1.close();
        }catch(Exception e){
            System.err.println("Connection failed!");
            System.err.println("Error: " + e.getMessage());
        }
    }
}
