/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.RoomSlot;
import model.Room;
import model.SeatSlot;
import model.Seat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 *
 * @author tongquangnam
 */
public class RoomSlotDAO extends DAO{
    
    public SeatSlotDAO ssDAO;
    public RoomDAO rDAO;
    SimpleDateFormat sdf;
    public RoomSlotDAO()
    {
        super();
        ssDAO = new SeatSlotDAO();
        rDAO = new RoomDAO();
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }
    
    
    /**
     * get RoomSlot by MovieSessionId in database.
     * @param movieSessionId
     * @return 
     */
    public RoomSlot getRoomSlotByMovieSessionId(int movieSessionId)
    {
        String sql = "SELECT * FROM tblRoomSlot WHERE movieSessionId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, movieSessionId);
            
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                int roomId = rs.getInt("roomId");
                Room room = rDAO.getRoomById(roomId);
                int roomSlotId = rs.getInt("roomSlotId");
                ArrayList<SeatSlot> array = ssDAO.getSeatSlotOfRoomSlot(roomSlotId);
                
                
                return new RoomSlot(roomSlotId , 
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
     * 
     * @param room
     * @param movieSessionId
     * @param datetime
     * @param movieLength
     * @param seatNormal
     * @param seatVip
     * @param seatDouble
     * @return 
     */
    public boolean addRoomSlot(Room room , int movieSessionId , Date datetime , float movieLength , long seatNormal , long seatVip , long seatDouble)
    {
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
                int newRoomSlotId = rs.getInt(1);
                
                for (Seat x : room.getSeats())
                {
                    if(x.getSeatType().equals("Normal"))
                        ssDAO.addSeatSlot(x , seatNormal , newRoomSlotId);
                    else if (x.getSeatType().equals("Vip"))
                    {
                        ssDAO.addSeatSlot(x, seatVip, newRoomSlotId);
                    }
                    else
                        ssDAO.addSeatSlot(x , seatDouble , newRoomSlotId);
                }
                return true;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    
    /**
     * 
     * @param roomId
     * @return 
     */
    public ArrayList<RoomSlot> getRoomSlotByRoomId(int roomId)
    {
        
        ArrayList<RoomSlot> array = new ArrayList<>();
        String sql = "SELECT * FROM tblRoomSLot WHERE roomId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1 , roomId);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                ArrayList<SeatSlot> sslots = ssDAO.getSeatSlotOfRoomSlot(rs.getInt("roomSlotId"));
                array.add(new RoomSlot(rs.getInt("roomSlotId") ,
                                        rDAO.getRoomById(roomId) ,
                                        sdf.parse(rs.getString("startTime")) ,
                                        rs.getFloat("movieLength") , 
                                        rs.getInt("movieSessionId") , 
                                        sslots
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
