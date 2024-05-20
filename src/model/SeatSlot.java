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
public class SeatSlot implements Serializable{

    
    private int seatSlot;
    private Seat seat;
    private long price;
    private String seatStatus;
    private int roomSlotId;

    public SeatSlot(int seatSlot, Seat seat, long price, String seatStatus, int roomSlotId) {
        this.seatSlot = seatSlot;
        this.seat = seat;
        this.price = price;
        this.seatStatus = seatStatus;
        this.roomSlotId = roomSlotId;
    }

    public int getSeatSlot() {
        return seatSlot;
    }

    public void setSeatSlot(int seatSlot) {
        this.seatSlot = seatSlot;
    }

    public Seat getSeat() {
        return this.seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public int getRoomSlotId() {
        return roomSlotId;
    }

    public void setRoomSlotId(int roomSlotId) {
        this.roomSlotId = roomSlotId;
    }

    @Override
    public String toString() {
        return "SeatSlot{" + "seatSlot=" + seatSlot + ", seat=" + seat + ", price=" + price + ", seatStatus=" + seatStatus + ", roomSlotId=" + roomSlotId + '}';
    }
    
    
    
}
