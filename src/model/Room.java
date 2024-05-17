/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tongquangnam
 */
public class Room implements Serializable{

    private int roomId;
    private String roomName;
    private String multiDemensional;
    private ArrayList<Seat> seats;

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
    
    
    public void addSeat(Seat newSeat)
    {
        seats.add(newSeat);
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getMultiDemensional() {
        return multiDemensional;
    }

    public void setMultiDemensional(String multiDemensional) {
        this.multiDemensional = multiDemensional;
    }

    public Room(int roomId, String roomName, String multiDemensional) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.multiDemensional = multiDemensional;
        this.seats = new ArrayList<>();
    }
    
    public Room(int roomId, String roomName, String multiDemensional , ArrayList<Seat> array) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.multiDemensional = multiDemensional;
        this.seats = array;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomName=" + roomName + ", multiDemensional=" + multiDemensional + ", seats=" + seats + '}';
    }
}
