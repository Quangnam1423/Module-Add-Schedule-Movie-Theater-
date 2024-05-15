/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author tongquangnam
 */
public class Room implements Serializable{
    private int roomId;
    private String roomName;
    private String multiDimensional;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    } 

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getMultiDimensional() {
        return multiDimensional;
    }

    public void setMultiDimentional(String multiDimentsional) {
        this.multiDimensional = multiDimentsional;
    }

    public Room(int roomId , String roomName , String multiDimensional)
    {
        this.roomId = roomId;
        this.multiDimensional = multiDimensional;
        this.roomName = roomName;
    }
    
    @Override
    
    public String toString()
    {
        return String.format("%d %s %s" , this.roomId , this.roomName , this.multiDimensional);
    }
}
