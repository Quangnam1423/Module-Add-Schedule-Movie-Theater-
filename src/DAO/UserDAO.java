/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tongquangnam
 */
public class UserDAO extends DAO{
    
    public UserDAO()
    {
        super();
    }
    /**
     *@param user
     *@return
     */
    public boolean checkValidLogin(User user)
    {
        boolean result = false;
        
        String sql = "Select username , password FROM  tblUser WHERE username = ? AND password = ?";
        try 
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            
            //get user that match with user need to check login
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }
    
    /**
     * 
     * @param username
     * @param password
     * @return 
     */
    public boolean addAccount (String username , String password)
    {
        
        String sql = "SELECT * FROM tblUser WHERE username = ?";
        String addAcount = "INSERT INTO dbo.tblUser(username , password) VALUES(? , ?);";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                return false;
            }
            else
            {
                ps = con.prepareStatement(addAcount);
                
                ps.setString(1, username);
                ps.setString(2 , password);
                
                int number = ps.executeUpdate();
                
                if (number != 0)
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
        return false;
    }
}
