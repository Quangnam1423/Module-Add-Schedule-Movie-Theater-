/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import model.Movie;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.ArrayList;


/**
 *
 * @author tongquangnam
 */
public class MovieDAO extends DAO{
    
    
    public MovieDAO()
    {
        super();
    }
    
    
    /**
     * 
     * @return 
     */
    public ArrayList<Movie> getAllMovie()
    {
        ArrayList<Movie> array = new ArrayList<>();
        String sql = "SELECT * FROM dbo.tblMovie ORDER BY movieName ASC";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                array.add(new Movie(rs.getInt("movieId") ,
                                    rs.getString("movieName") ,
                                    rs.getString("descript") ,
                                    rs.getFloat("movieLength") ,
                                    rs.getString("movieLanguage") ,
                                    rs.getFloat("rating")
                                ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return array;
    }
    
    
    
    /**
     * 
     * @param movieName
     * @return 
     */
    public ArrayList<Movie> getMovieByName(String movieName)
    {
        ArrayList<Movie> array = new ArrayList<>();
        String sql = "SELECT * FROM dbo.tblMovie WHERE movieName COLLATE SQL_Latin1_General_CP1_CI_AS LIKE ?";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1 ,"%" + movieName + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                array.add(new Movie(rs.getInt("movieId") ,
                                    rs.getString("movieName") ,
                                    rs.getString("descript") ,
                                    rs.getFloat("movieLength") ,
                                    rs.getString("movieLanguage") ,
                                    rs.getFloat("rating")
                                ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return array;
    }
    
    
    
    
    /**
     * 
     * @param movieId
     * @return 
     */
    public Movie getMovieById(int movieId)
    {
        String sql = "SELECT * FROM dbo.tblMovie WHERE movieId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1 , movieId);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                return new Movie(rs.getInt("movieId") ,
                                    rs.getString("movieName") ,
                                    rs.getString("descript") ,
                                    rs.getFloat("movieLength") ,
                                    rs.getString("movieLanguage") ,
                                    rs.getFloat("rating")
                                );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * 
     * @param rating
     * @return 
     */
    public ArrayList<Movie> getMovieByHigherRating(float rating)
    {
        ArrayList<Movie> array = new ArrayList<>();
        
        String sql = "SELECT * FROM tblMovie WHERE rating >= ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setFloat(1 , rating);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                array.add(new Movie(rs.getInt("movieId") ,
                                    rs.getString("movieName") ,
                                    rs.getString("descript") ,
                                    rs.getFloat("movieLength") ,
                                    rs.getString("movieLanguage") ,
                                    rs.getFloat("rating")
                                ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return array;
    }
    
    
    /**
     * 
     * @param movieName
     * @param rating
     * @return 
     */
    public ArrayList<Movie> getMovieByNameAndRating(String movieName , float rating)
    {
        ArrayList<Movie> array = new ArrayList<>();
        String sql = "SELECT * FROM dbo.tblMovie where movieName Like ? and rating >= ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1,"%" + movieName + "%");
            ps.setFloat(2, rating);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                array.add(new Movie(rs.getInt("movieId") ,
                                    rs.getString("movieName") ,
                                    rs.getString("descript") ,
                                    rs.getFloat("movieLength") ,
                                    rs.getString("movieLanguage") ,
                                    rs.getFloat("rating")
                                ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return array;
    }
}
