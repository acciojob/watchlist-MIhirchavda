package com.driver;

import java.security.PrivateKey;

//Director.java Class - String name, int numberOfMovies, double imdbRating,
// no-args constructor, all-args constructor and getters-setters
public class Director {

    private String name;
    private int numberOfMovies;
    private double imdbRating;
    // no-args constructor
    public void Director(){

    }

    //all-args constructor
    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
