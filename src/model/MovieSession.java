/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author tongquangnam
 */

public class MovieSession implements Serializable{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    
    private int movieSessionId;
    private Movie movie;
    private Room room;
    private Date startTime;
    private long seatNormal;
    private long seatVip;
    private long seatDouble;

    
    
    public MovieSession(Movie movie, Room room, String Time, long seatNormal, long seatVip, long seatDouble) {
        this.movie = movie;
        this.room = room;
        try
        {
            this.startTime = sdf.parse(Time);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        this.seatNormal = seatNormal;
        this.seatVip = seatVip;
        this.seatDouble = seatDouble;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStarttime(Date dateTime) {
        this.startTime = dateTime;
    }

    public int getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(int movieSessionId) {
        this.movieSessionId = movieSessionId;
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
    
}
