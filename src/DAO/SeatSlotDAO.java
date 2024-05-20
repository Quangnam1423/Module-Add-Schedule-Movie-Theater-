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
    
    
    private SeatDAO seatDao = new SeatDAO();
    public SeatSlotDAO()
    {
        super();
    }
    
    
    /**
     * add SeatSlot into the database , 
     * @param seat
     * @param price
     * @param roomSlotId
     * @return 
     */
    public boolean addSeatSlot(Seat seat , long price , int roomSlotId)
    {
        boolean check = false;
        
        String sql = "INSERT INTO tblSeatSlot(seatId , price , roomSlotId) VALUES (? , ? , ?);";
        try
        {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1 , seat.getSeatId());
            ps.setString(2 , seat.getSeatType());
            ps.setInt(3 , roomSlotId);
            
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
    
    
   
    /**
     * 
     * @param roomSlotId
     * @return 
     */
    public ArrayList<SeatSlot> getSeatSlotOfRoomSlot(int roomSlotId)
    {
        ArrayList<SeatSlot> seatslots = new ArrayList<>();
        
        
        String sql = "SELECT *FROM dbo.tblSeatSlot  b WHERE b.roomSlotId = ?;";
        
        try
        {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, roomSlotId);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                int seatId = rs.getInt("seatId");
                Seat seat = seatDao.getSeatBySeatId(seatId);
                seatslots.add(new SeatSlot(rs.getInt("seatSlotId") , 
                                        seat , 
                                        rs.getInt("price") , 
                                        rs.getString("seatStatus") , 
                                        roomSlotId
                                                ));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();;
        }
        
        return seatslots;
    }
}
