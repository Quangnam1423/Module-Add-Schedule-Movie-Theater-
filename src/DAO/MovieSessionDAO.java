/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


/**
 *
 * @author tongquangnam
 */
public class MovieSessionDAO extends DAO{
    
    private static SimpleDateFormat sdf;
    private RoomDAO rDAO;
    private MovieDAO mDAO;
    private SeatSlotDAO ssDAO;
    public MovieSessionDAO()
    {
        super();
        rDAO = new RoomDAO();
        mDAO = new MovieDAO();
        ssDAO = new SeatSlotDAO();
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    /**
     * add a movieSession into the database.
     * @param movie
     * @param room
     * @param startTime
     * @param seatNormal
     * @param seatVip
     * @param seatDouble
     * @return 
     */
    public boolean addMovieSessionDAO(Movie movie , 
                                        Room room , 
                                        String startTime , 
                                        long seatNormal , 
                                        long seatVip , 
                                        long seatDouble)
    {
        boolean check = true;
        String sql = "INSERT INTO dbo.tblMovieSession(movieId , roomId , startTime , seatNormal , seatVip , seatDouble)"
                + "VALUES(? , ? , ? , ? , ? , ?);";
        String sqlAddRoomSlot = "INSERT INTO dbo.tblRoomSlot(roomId , movieSessionId , startTime , movieLength)"
                + "VALUES(? , ? , ? , ?)";
        
        String sqlAddSeatSlot = "INSERT INTO dbo.tblSeatSlot(seatId , price , roomSlotId)"
                + "VALUES(? , ? , ?);";
        
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, movie.getMovieId());
            ps.setInt(2 , room.getRoomId());
            ps.setString(3 , startTime);
            ps.setLong(4 , seatNormal);
            ps.setLong(5 , seatVip);
            ps.setLong(6, seatDouble);
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next())
            {
                int newMovieSessionId = rs.getInt(1);
                ps = con.prepareStatement(sqlAddRoomSlot , Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, room.getRoomId());
                ps.setInt(2 , newMovieSessionId);
                ps.setString(3 , startTime);
                ps.setFloat(4 , movie.getMovieLength());
                
                ps.executeUpdate();
                
                rs = ps.getGeneratedKeys();
                
                if (rs.next())
                {
                    int newRoomSlotId = rs.getInt(1);
                    
                    for (Seat x : room.getSeats())
                    {
                        ps = con.prepareStatement(sqlAddSeatSlot);
                        
                        ps.setInt(1, x.getSeatId());
                        
                        if (x.getSeatType().equals("Normal") == true)
                        {
                            ps.setLong(2 , seatNormal);
                        }
                        else if (x.getSeatType().equals("Vip") == true)
                        {
                            ps.setLong(2 , seatVip);
                        }
                        else 
                        {
                            ps.setLong(2 , seatDouble);
                        }
                        
                        ps.setInt(3 , newRoomSlotId);
                        
                        ps.executeUpdate();
                    }
                }
            }
            else
            {
                return !check;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return check;
    }
}
