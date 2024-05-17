/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.RoomSlot;
import model.Room;
import model.SeatSlot;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


/**
 *
 * @author tongquangnam
 */
public class RoomSlotDAO extends DAO{
    
    public static SeatSlotDAO ssDAO = new SeatSlotDAO();
    public static RoomDAO rDAO = new RoomDAO();
    public RoomSlotDAO()
    {
        super();
    }
    
    
    /**
     * get RoomSlot by MovieSessionId in database.
     * @param movieSessionId
     * @return 
     */
    public static RoomSlot getRoomSlotByMovieSessionId(int movieSessionId)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String sql = "SELECT * FROM tblRoomSlot  b WHERE b.movieSessionId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, movieSessionId);
            
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                int roomId = rs.getInt("roomId");
                Room room = rDAO.getRoomById(roomId);
                ArrayList<SeatSlot> array = ssDAO.getSeatSlotOfRoomSlot(rs.getInt("roomSlotId"));
                
                
                return new RoomSlot(rs.getInt("roomSlotId") , 
                                    room , 
                                    sdf.parse(rs.getString("startTime")) ,
                                    rs.getFloat("movieLength") , 
                                    movieSessionId ,
                                    array
                                );
                
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * add a RoomSlot object in the database.
     * @param room
     * @param movieSessionId
     * @param datetime
     * @return 
     */
    public static boolean addRoomSlot(Room room , int movieSessionId , Date datetime , float movieLength)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        boolean result = true;
        
        String sql = "INSERT INTO tblRoomSlot(roomId , movieSessionId , startTime , movieLength) VALUES(? , ? , ? , ?);";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1 , room.getRoomId());
            ps.setInt(2 , movieSessionId);
            ps.setString(3 , sdf.format(datetime));
            ps.setFloat(4, movieLength);
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next())
            {
                return result;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    
}
