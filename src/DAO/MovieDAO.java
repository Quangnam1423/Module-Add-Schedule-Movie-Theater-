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
     *get all movie from database
     *@return
     */
    
    public ArrayList<Movie> getAllMovie()
    {
        ArrayList<Movie> Movies = new ArrayList<>();
        
        
        String sqlgetAllFilm = "SELECT * from tblMovie;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlgetAllFilm);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Movies.add(new Movie(rs.getInt("movieId") , 
                                     rs.getString("name") , 
                                     rs.getString("description"),
                                     rs.getDouble("length") , 
                                     rs.getString("language") , 
                                     rs.getDouble("rating")
                         ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return Movies;
    }
    
    /**
     *@param movieName
     *@return 
    */
    
    public ArrayList<Movie> searchRoom(String movieName)
    {
        ArrayList<Movie> Movies = new ArrayList<>();
        
        String sqlGetByName = "SELECT * from tblMovie WHERE name LIKE ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sqlGetByName);
            
            ps.setString(1 , movieName);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Movies.add(new Movie(rs.getInt("movieId") , 
                                     rs.getString("name") , 
                                     rs.getString("description"),
                                     rs.getDouble("length") , 
                                     rs.getString("language") , 
                                     rs.getDouble("rating")
                         ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return Movies;
    }
    
    /*
    *@param rate
    *@return
    */
    public ArrayList<Movie> searchMovieWithHigherRating(double Rate)
    {
        
        
        ArrayList<Movie> Movies = new ArrayList<>();
        String sqlGetMovie = "SELECT * tblMovie WHERE rating > ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sqlGetMovie);
            
            ps.setDouble(1, Rate);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Movies.add(new Movie(
                                     rs.getInt("movieId") , 
                                     rs.getString("name") , 
                                     rs.getString("description"),
                                     rs.getDouble("length") , 
                                     rs.getString("language") , 
                                     rs.getDouble("rating")
                           ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return Movies;
    }
    
    
}
