/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Seat;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author tongquangnam
 */
public class SeatDAO extends DAO{
    
    public SeatDAO()
    {
        super();
    }
    
    
    public static void main(String[] args)
    {
        SeatDAO test = new SeatDAO();
        
        ArrayList<Seat> array = test.getAllSeatByRoomId(2);
        
        for (Seat x : array)
        {
            System.out.println(x);
        }
    }
    
    /**
     * 
     * @param roomId
     * @return 
     */
    public ArrayList<Seat> getAllSeatByRoomId(int roomId)
    {
        ArrayList<Seat> array = new ArrayList<>();
        
        String sql = "SELECT * FROM dbo.tblSeat WHERE roomId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, roomId);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                array.add(new Seat( rs.getInt("seatId") ,
                                    rs.getInt("col") ,
                                    rs.getInt("ro") ,
                                    rs.getString("seatType") ,
                                    rs.getString("descript") ,
                                    rs.getInt("roomId")
                    ));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return array;
    }
    
    
    /**
     * 
     * @param seatId
     * @return 
     */
    public  Seat getSeatBySeatId (int seatId)
    {
        String sql = "SELECT * FROM dbo.tblSeat WHERE seatId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                return new Seat( rs.getInt("seatId") ,
                                    rs.getInt("col") ,
                                    rs.getInt("ro") ,
                                    rs.getString("seatType") ,
                                    rs.getString("descript") ,
                                    rs.getInt("roomId")
                            );
            }
            else
                return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    //////////////////////////////////////////////////////////
}
