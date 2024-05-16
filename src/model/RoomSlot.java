/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;


/**
 *
 * @author tongquangnam
 */
public class RoomSlot implements Serializable{
    
    private int roomSlotId;
    private Room room;
    private Date startTime;
    private float movieLength;
    private int movieSessionId;
    private ArrayList<SeatSlot> SeatSlots;

    public ArrayList<SeatSlot> getSeatSlots() {
        return SeatSlots;
    }

    public void setSeatSlots(ArrayList<SeatSlot> SeatSlots) {
        this.SeatSlots = SeatSlots;
    }
    
    public void addSeatSlot (SeatSlot sl)
    {
        this.SeatSlots.add(sl);
    }

    public int getRoomSlotId() {
        return roomSlotId;
    }

    public void setRoomSlotId(int roomSlotId) {
        this.roomSlotId = roomSlotId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoomId(Room room) {
        this.room = room;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public float getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(float movieLength) {
        this.movieLength = movieLength;
    }

    public int getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(int movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public RoomSlot(int roomSlotId, Room room, Date startTime, float movieLength, int movieSessionId) {
        this.roomSlotId = roomSlotId;
        this.room = room;
        this.startTime = startTime;
        this.movieLength = movieLength;
        this.movieSessionId = movieSessionId;
        this.SeatSlots = new ArrayList<>();
    }
    
public RoomSlot(int roomSlotId, Room room, Date startTime, float movieLength, int movieSessionId , ArrayList<SeatSlot> array) {
        this.roomSlotId = roomSlotId;
        this.room = room;
        this.startTime = startTime;
        this.movieLength = movieLength;
        this.movieSessionId = movieSessionId;
        this.SeatSlots = array;
    }

}
