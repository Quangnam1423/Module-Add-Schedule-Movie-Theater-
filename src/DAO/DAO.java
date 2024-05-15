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
            String dbUrl = "jdbc:mysql://localhost:3306/movieTheater";
            try
            {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(dbUrl , "root" , "@Tongquangnam2003");
                
                System.out.println("Connected to MySQL database");
                
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
}
