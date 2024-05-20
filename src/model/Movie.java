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
public class Movie implements Serializable{

    
    private int movieId;
    private String movieName;
    private String descript;
    private float movieLength;
    private String movieLanguage;
    private float rating;

    public Movie(int movieId, String movieName, String descript, float movieLength, String movieLanguage, float rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.descript = descript;
        this.movieLength = movieLength;
        this.movieLanguage = movieLanguage;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public float getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(float movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId=" + movieId + ", movieName=" + movieName + ", descript=" + descript + ", movieLength=" + movieLength + ", movieLanguage=" + movieLanguage + ", rating=" + rating + '}';
    }
  
}
