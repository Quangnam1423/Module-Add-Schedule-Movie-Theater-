/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package addschedule;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import view.*;
import model.*;
import DAO.*;


public class AddSchedule {
    
    private Movie movie;
    private Room room;
    
    private String DateTime;
    private long SeatNormal;
    private long SeatVip;
    private long SeatDouble;
    private MovieSessionDAO msDAO;
    
    public boolean Save()
    {
        return msDAO.addMovieSessionDAO(movie, room, DateTime, SeatNormal, SeatVip, SeatDouble);
    }
    
    public static void main(String[] args)
    {
        AddSchedule addSchedule = new AddSchedule();
        new LoginFrm(addSchedule).setVisible(true);
    }
    
    public AddSchedule() {
        this.msDAO = new MovieSessionDAO();
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

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }

    public long getSeatNormal() {
        return SeatNormal;
    }

    public void setSeatNormal(long SeatNormal) {
        this.SeatNormal = SeatNormal;
    }

    public long getSeatVip() {
        return SeatVip;
    }

    public void setSeatVip(long SeatVip) {
        this.SeatVip = SeatVip;
    }

    public long getSeatDouble() {
        return SeatDouble;
    }

    public void setSeatDouble(long SeatDouble) {
        this.SeatDouble = SeatDouble;
    }

    public MovieSessionDAO getMsDAO() {
        return msDAO;
    }

    public void setMsDAO(MovieSessionDAO msDAO) {
        this.msDAO = msDAO;
    }
    
    
}