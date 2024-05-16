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

public class MovieSession implements Serializable{

    public int getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(int movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public long getSeatNormal() {
        return seatNormal;
    }

    public void setSeatNormal(long seatNormal) {
        this.seatNormal = seatNormal;
    }

    public long getSeatVip() {
        return seatVip;
    }

    public void setSeatVip(long seatVip) {
        this.seatVip = seatVip;
    }

    public long getSeatDouble() {
        return seatDouble;
    }

    public void setSeatDouble(long seatDouble) {
        this.seatDouble = seatDouble;
    }

    public MovieSession(int movieSessionId, int roomId, int movieId, String datetime, long seatNormal, long seatVip, long seatDouble) {
        this.movieSessionId = movieSessionId;
        this.roomId = roomId;
        this.movieId = movieId;
        this.datetime = datetime ;
        this.seatNormal = seatNormal;
        this.seatVip = seatVip;
        this.seatDouble = seatDouble;
    }
    
    
    private int movieSessionId;
    private int roomId;
    private int movieId;
    private String datetime;
    private long seatNormal;
    private long seatVip;
    private long seatDouble;
    
    
    
}
