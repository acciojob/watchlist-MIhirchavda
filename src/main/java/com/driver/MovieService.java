package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addM(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addD(Director director){
        movieRepository.addDirector(director);
    }
    public Movie getM(String name){
        return movieRepository.getMovie(name);
    }
    public Director getD(String name){
        return movieRepository.getDirector(name);
    }
    public List<Movie> getAllM(){
        return movieRepository.getAllMovie();
    }
    public void addMoAndDi(String movie ,String director){
        movieRepository.addMovieAndDirector(movie , director);
    }
    public void deleteMovAndDire(String director){
        movieRepository.deleteDirectorByName(director);
    }
    public void deleteAllDi(){
        movieRepository.deleteAllDirector();
    }

}
