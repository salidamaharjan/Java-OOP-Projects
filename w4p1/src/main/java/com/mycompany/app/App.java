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
//            preparedStatement.setString(1, "ABC");
//            preparedStatement.setString(2, "MCS" );
//            preparedStatement.executeUpdate();
//            System.out.println("Student added");
//            preparedStatement.close();
            // View all Student's name
            PreparedStatement preparedStatement1 = conn.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = preparedStatement1.executeQuery();
            System.out.println("Name of Students ↓");
            while(resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }
            resultSet.close();
            preparedStatement1.close();
            // Get student by id
            PreparedStatement preparedStatement2 = conn.prepareStatement("SELECT name From student where id = ?");
            preparedStatement2.setInt(1, 1);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while(resultSet2.next()){
                System.out.println("Student with id 1: " + resultSet2.getString("name"));
            }
            resultSet2.close();
            preparedStatement2.close();
            // update the db
            PreparedStatement preparedStatement3 = conn.prepareStatement("UPDATE student Set name = ? WHERE name = ?");
            preparedStatement3.setString(1, "XYZ");
            preparedStatement3.setString(2, "ABC");
            preparedStatement3.executeUpdate();
            System.out.println("Name updated.");
        }catch(Exception e){
            System.err.println("Connection failed!");
            System.err.println("Error: " + e.getMessage());
        }
    }
}
