/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Seat;
import model.SeatSlot;

/**
 *
 * @author tongquangnam
 */
public class SeatSlotDAO extends DAO{
    
    public SeatSlotDAO()
    {
        super();
    }
    
    
    /**
     * get All SeatSlot of MovieSession by movieSessionId
     * @param movieSessionId
     * @return 
     */
    public ArrayList<SeatSlot> getSeatSlotByMovieSessionId(int movieSessionId)
    {
        ArrayList<SeatSlot> result = new ArrayList<>();
        
        String sql = "SELECT * FROM tblSeatSlot WHERE movieSessionId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1 , movieSessionId);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int seatId = rs.getInt("seatId");
                Seat seat = SeatDAO.getSeatById(seatId);
                SeatSlot ss = new SeatSlot(seat , 
                                           rs.getString("status") , 
                                           rs.getLong("price") , 
                                           rs.getInt("movieSessionId")
                                        );
                
                result.add(ss);
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return result;
    }
    
    
    /**
     * add SeatSlot into the database , 
     * @param seat
     * @param price
     * @param movieSessionId
     * @return 
     */
    public boolean addSeatSlot(Seat seat , long price , int movieSessionId)
    {
        boolean check = false;
        
        String sql = "INSERT INTO tblSeatSlot(seatId , status , type , movieSessionId) VALUES (? , ? , ? , ?);";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1 , seat.getSeatId());
            ps.setString(2 , "Trong");
            ps.setString(3 , seat.getType());
            ps.setInt(4 , movieSessionId);
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next())
            {
                check = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return check;  
    }
}
