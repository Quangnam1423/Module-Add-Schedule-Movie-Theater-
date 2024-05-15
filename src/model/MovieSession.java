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

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MovieSession implements Serializable{
    private int movieSessionId;
    private int movieId;
    private Date datetime;
    private float length;
    private long seatNormal;
    private long seatVip;
    private long seatDouble;



    public MovieSession(int movieSessionId, 
                        int movieId, 
                        Date datetime, 
                        float length, 
                        long seatNormal, 
                        long seatVip, 
                        long seatDouble) 
    {
        this.movieSessionId = movieSessionId;
        this.movieId = movieId;
        this.datetime = datetime;
        this.length = length;
        this.seatNormal = seatNormal;
        this.seatVip = seatVip;
        this.seatDouble = seatDouble;
    }
    
    
    
        public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }


    public int getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(int movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public long getSeatNormal() {
        return seatNormal;
    }

    public void setSeatNormal(int seatNormal) {
        this.seatNormal = seatNormal;
    }

    public long getSeatVip() {
        return seatVip;
    }

    public void setSeatVip(int seatVip) {
        this.seatVip = seatVip;
    }

    public long getSeatDouble() {
        return seatDouble;
    }

    public void setSeatDouble(int seatDouble) {
        this.seatDouble = seatDouble;
    }
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    
    
    public MovieSession(int movieSessionId, int movieId, int roomSlotId, String date, float length, int seatNormal, int seatVip, int seatDouble) {
        this.movieSessionId = movieSessionId;
        this.movieId = movieId;
        try
        {
            this.datetime = dateFormat.parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        this.length = length;
        this.seatNormal = seatNormal;
        this.seatVip = seatVip;
        this.seatDouble = seatDouble;
    }
    
    @Override
    
    public String toString()
    {
        return String.format("%d %d %s %.1f %d %d %d", this.movieSessionId , 
                this.movieId , 
                dateFormat.format(datetime) , 
                this.length , 
                this.seatNormal , this.seatVip , 
                this.seatDouble);
    }
    
}
