package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Component
public class MovieRepository {
    //for movie storage
    HashMap<String , Movie> movie_list;
    // for director storage
    HashMap<String,Director> director_list;
    // for movie and director pair storage
    HashMap< String, List<String> > pair_list;

    public MovieRepository(){
        this.movie_list = new HashMap<>();
        this.director_list = new HashMap<>();
        this.pair_list = new HashMap<>();
    }
    public  void addMovie(Movie movie){
        movie_list.put(movie.getName() , movie);
    }
    public void addDirector(Director director){
        director_list.put(director.getName() , director);
    }

    public Movie getMovie(String name){
        return movie_list.get(name);
    }
    public Director getDirector(String name){
        return director_list.get(name);
    }
    public List<String> getAllMovie(){
        List<String>movies = new ArrayList<>();
        for(Movie m : movie_list.values()){
            movies.add(m.getName());
        }
        return movies;
    }
    public void addMovieAndDirector(String movie , String director){

        if(movie_list.containsKey(movie) && director_list.containsKey(director)){
            List<String > curMovielist = new ArrayList<>();
            Movie m = movie_list.get(movie);
            Director d = director_list.get(director);
            if(pair_list.containsKey(d.getName())){
                curMovielist = pair_list.get(d.getName());
            }
            curMovielist.add(m.getName());
            pair_list.put(d.getName() , curMovielist);
        }

    }

    public void deleteDirectorByName (String director){
        if(director_list.containsKey(director)){
            Director d = director_list.get(director);
            director_list.remove(director);
            List<String> curlist = pair_list.get(d.getName());
            for(String m : curlist){
                movie_list.remove(m);
            }
            pair_list.remove(d.getName());
        }

    }
    public void deleteAllDirector (){
        for(String dir : pair_list.keySet()){

            director_list.remove(dir);
            for(String m : pair_list.get(dir)){
                movie_list.remove(m);
            }
            pair_list.remove(dir);
        }
    }
    public List<String> getMovieByDirector(String director){
        List<String> list = new ArrayList<>();
        if(pair_list.containsKey(director)){
            list = pair_list.get(director);
        }
        return list;
    }

}
