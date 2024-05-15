/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package addschedule;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.DAO;

public class AddSchedule {
    
    
    
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/movieTheater"; // Replace 'mydatabase' with your database name
        String username = "root";
        String password = "@Tongquangnam2003";

        // JDBC connection object
        Connection connection = null;

        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            connection = DriverManager.getConnection(url, username, password);

            // Print connection success message
            System.out.println("Connected to MySQL database!");

            // You can perform database operations here...cj.
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle Class.forName() exceptions
            e.printStackTrace();
        } finally {
            // Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}