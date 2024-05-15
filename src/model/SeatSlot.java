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
    private Seat seat;
    private String status;
    private long type;
    private int movieSessionId;

    public int getMovieSessionId() {
        return movieSessionId;
    }

    @Override
    public String toString() {
        return "SeatSlot{" + "seat=" + seat + ", status=" + status + ", type=" + type + ", movieSessionId=" + movieSessionId + '}';
    }

    public void setMovieSessionId(int movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public SeatSlot(Seat seat, String status, long type, int movieSessionId) {
        this.seat = seat;
        this.status = status;
        this.type = type;
        this.movieSessionId = movieSessionId;
    }

    public SeatSlot(Seat seat, String status, long type) {
        this.seat = seat;
        this.status = status;
        this.type = type;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }
    
}
