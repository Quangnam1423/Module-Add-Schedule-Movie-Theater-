/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author tongquangnam
 */
public class RoomSlot implements Serializable{
    private Room room;
    private int roomSlotId;
    private int movieSessionId;   
    private Date Datetime;
    
    @Override
    public String toString() {
        return "RoomSlot{" + "room=" + room + ", roomSlotId=" + roomSlotId + ", movieSessionId=" + movieSessionId + ", Datetime=" + Datetime + '}';
    }

    public int getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(int movieSessionId) {
        this.movieSessionId = movieSessionId;
    }


    public RoomSlot(Room room, int roomSlotId, int movieSessionId, Date Datetime) {
        this.room = room;
        this.roomSlotId = roomSlotId;
        this.movieSessionId = movieSessionId;
        this.Datetime = Datetime;
    }



    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoomSlotId() {
        return roomSlotId;
    }

    public void setRoomSlotId(int roomSlotId) {
        this.roomSlotId = roomSlotId;
    }

    public Date getDatetime() {
        return Datetime;
    }

    public void setDatetime(Date Datetime) {
        this.Datetime = Datetime;
    }
    
    
}
