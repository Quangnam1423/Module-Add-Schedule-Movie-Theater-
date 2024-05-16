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
    
    
    public RoomDAO()
    {
        super();
    }
    /**
     *get room by RoomID
     *@param roomId
     *@return
     */
    
    public static Room getRoomById(int roomId)
    {
        String sql = "SELECT * FROM tblRoom where roomId = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , roomId);
            
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                Room room = new Room(rs.getInt("roomId") , rs.getString("roomName") , rs.getString("multiDimensional"));
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
        
        String sql = "SELECT * from tblRoom WHERE roomName LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1 , roomName);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                Room Room = new Room(rs.getInt("roomId") , rs.getString("roomName") , rs.getString("multiDimensional"));
                result.add(Room);
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
        
        String sql = "SELECT * FROM tblRoom";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                array.add(new Room(rs.getInt("roomId") , rs.getString("roomName") , rs.getString("multiDimensional")));
            }
        }
        catch( SQLException e)
        {
            e.printStackTrace();
        }
        
        return array;
    }
}
