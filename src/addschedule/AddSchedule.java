/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package addschedule;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AddSchedule {
    
    
    
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:sqlserver://TQN-PTIT:1433;databaseName=MovieTheater;encrypt=true;trustServerCertificate=true"; // Replace 'mydatabase' with your database name
        String username = "sa";
        String password = "12345";

        // JDBC connection object
        Connection connection = null;

        try {
            // Register MySQL JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

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