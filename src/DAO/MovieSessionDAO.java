/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.MovieSession;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;


/**
 *
 * @author tongquangnam
 */
public class MovieSessionDAO extends DAO{
    
    public MovieSessionDAO()
    {
        super();
    }
    
    
    /**
     * 
     * @param roomId
     * @param movieId
     * @param datetime
     * @param seatNormal
     * @param seatVip
     * @param seatDouble
     * @return 
     */
    public MovieSession addMovieSession(int roomId , int movieId , String datetime , long seatNormal , long seatVip , long seatDouble)
    {
        
        String sql = "INSERT INTO tblMovieSession(roomId , movieId , datetime , seatNormal , seatVip , seatDouble)"
                        + "VALUES(? , ? , ? , ? , ? , ?);";
        
        try 
        {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, roomId);
            ps.setInt(2, movieId);
            ps.setString(3, datetime);
            ps.setLong(4 , seatNormal);
            ps.setLong(5 , seatVip);
            ps.setLong(6 , seatDouble);
            
            ps.executeUpdate();
            
            ResultSet generateKeys = ps.getGeneratedKeys();
            
            if (generateKeys.next())
            {
                return new MovieSession(generateKeys.getInt(1) , 
                                        roomId , 
                                        movieId ,
                                        datetime ,
                                        seatNormal ,
                                        seatVip ,
                                        seatDouble
                                        );
            }
        }
        catch(Exception ex)
        {
            
            ex.printStackTrace();
            return null;
        }
        
        return null;
    }
}
