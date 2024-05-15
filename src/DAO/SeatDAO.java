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
    
    /**
     *return all the Seat entity that match with roomId
     *@param roomId
     *@return
     */
    public ArrayList<Seat> getAllSeatByRoomId(int roomId)
    {
        ArrayList<Seat> array = new ArrayList<>();
        String sql = "SELECT * from tblSeat WHERE roomId = ?";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1 , roomId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Seat seat = new Seat(rs.getInt("roomId") , 
                                     rs.getString("type") , 
                                     rs.getInt("column") ,
                                     rs.getInt("row") ,
                                     rs.getString("description") , 
                                     rs.getInt("roomId")
                                    );
                array.add(seat);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        // return the array of seat that match with roomId
        return array;
    }
    
    
    
    /**
     * 
     * @param seatId
     * @return 
     */
    public static Seat getSeatById(int seatId)
    {
        String sql = "SELECT * from tblSear WHERE seatId = ?;";
        
                try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1 , seatId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Seat seat = new Seat(rs.getInt("roomId") , 
                                     rs.getString("type") , 
                                     rs.getInt("column") ,
                                     rs.getInt("row") ,
                                     rs.getString("description") , 
                                     rs.getInt("roomId")
                                    );
                return seat;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
