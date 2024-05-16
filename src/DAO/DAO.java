/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tongquangnam
 */
public class DAO {
    public static Connection con;
    
    public DAO(){
        if (con == null)
        {
            String dbUrl = "jdbc:sqlserver://TQN-PTIT:1433;databaseName=MovieTheater;encrypt=true;trustServerCertificate=true";
            try
            {
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(dbUrl , "sa" , "12345");
                
                System.out.println("Connected to SQL server database");
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("fail to connect to SQL server");
            }
        }
    }
}
