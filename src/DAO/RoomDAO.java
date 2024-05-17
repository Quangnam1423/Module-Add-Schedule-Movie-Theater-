/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Room;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author tongquangnam
 */
public class RoomDAO extends DAO{
    
    public static SeatDAO sDAO = new SeatDAO();
    public RoomDAO()
    {
        super();
    }
    
    
    public static void main(String[] args)
    {
        RoomDAO rDAO = new RoomDAO();
        
        Room room = rDAO.getRoomById(1);
        
        System.out.println(room);
    }
     
    /**
     *get room by RoomID
     *@param roomId
     *@return
     */
    
    public Room getRoomById(int roomId)
    {
        String sql = "SELECT * FROM tblRoom where roomId = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , roomId);
            
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                Room room = new Room(rs.getInt("roomId") , rs.getString("roomName") , rs.getString("multiDimensional"));
                room.setSeats(sDAO.getAllSeatByRoomId(room.getRoomId()));
                return room;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    /**
     *get all room entity that have the name like input
     *@param roomName
     *@return
     */
    public static ArrayList<Room> searchRoom(String roomName)
    {
        ArrayList<Room> result = new ArrayList<>();
        
        String sql = "SELECT * from tblRoom WHERE roomName LIKE ? ORDER BY roomName ASC";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1 ,"%" + roomName+ "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Room room = new Room(rs.getInt("roomId") , rs.getString("roomName") , rs.getString("multiDimensional"));

                room.setSeats(sDAO.getAllSeatByRoomId(room.getRoomId()));
                
                result.add(room);
            }
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    
    
    /**
     *get all room entity
     *@return
     */
    public static ArrayList<Room> getAllRoom()
    {
        ArrayList<Room> array = new ArrayList<>();
        
        String sql = "SELECT * FROM tblRoom ORDER BY roomId ASC";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Room room = new Room(rs.getInt("roomId") , rs.getString("roomName") , rs.getString("multiDimensional"));
                room.setSeats(sDAO.getAllSeatByRoomId(room.getRoomId()));
                array.add(room);
            }
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        }
        
        return array;
    }
}
