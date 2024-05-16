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
public class Seat implements Serializable{
    
    private int seatId;
    private int col;
    private int ro;
    private String seatType;
    private String descript;
    private int roomId;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRo() {
        return ro;
    }

    public void setRo(int ro) {
        this.ro = ro;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Seat(int seatId, int col, int ro, String seatType, String descript, int roomId) {
        this.seatId = seatId;
        this.col = col;
        this.ro = ro;
        this.seatType = seatType;
        this.descript = descript;
        this.roomId = roomId;
    }
    
    
}
