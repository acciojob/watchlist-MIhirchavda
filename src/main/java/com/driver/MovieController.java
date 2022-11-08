package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

// 1 2 4 5 7 3 8
    @Autowired
    MovieService movieService;

    //Add a movie: POST /movies/add-movie
    //Pass the Movie object as request body
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - addMovie
    @PostMapping("/add-movie") //  postman done
    public ResponseEntity<String> addMovie(@RequestBody  Movie movie){
        movieService.addM(movie);

        return new ResponseEntity<>("add movie done" , HttpStatus.OK);
    }

    //Add a director: POST /movies/add-director
    //Pass the Director object as request body
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - addDirector
    @PostMapping("add-director")
    public  ResponseEntity<String > addDirector(@RequestBody Director director){
        movieService.addD(director);

        return new ResponseEntity<>("add director done" , HttpStatus.OK);
    }

    //Get Movie by movie name: GET /movies/get-movie-by-name/{name}
    //Pass movie name as path parameter
    //Return Movie object wrapped in a ResponseEntity object
    //Controller Name - getMovieByName
    @GetMapping("/get-movie-by-name/{name}") // postman done
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie m = movieService.getM(name);

        return new  ResponseEntity<>( m , HttpStatus.OK);
    }

   /* Get Director by director name: GET /movies/get-director-by-name/{name}
    Pass director name as path parameter
    Return Director object wrapped in a ResponseEntity object
    Controller Name - getDirectorByName */

    @GetMapping("/get-director-by-name/{name}") // postman done
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director d = movieService.getD(name);
        //return  d;
        return new ResponseEntity<>(d ,HttpStatus.OK);
    }

    //Get List of all movies added: GET /movies/get-all-movies
    //No params or body required
    //Return List of movies name(List()) wrapped in a ResponseEntity object
    //Controller Name - findAllMovies
    @GetMapping("/get-all-movies") // postman done
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> m = movieService.getAllM();
        return new ResponseEntity<>(m ,HttpStatus.OK);
    }

    //Pair an existing movie and director: PUT /movies/add-movie-director-pair
    //Pass movie name and director name as request parameters
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - addMovieDirectorPair

    @PostMapping("/add-movie-director-pair") // postman done
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie ,
                                                       @RequestParam String director){
        movieService.addMoAndDi(movie , director);
        return  new ResponseEntity<>("add movie and director done" , HttpStatus.OK);

    }

    //Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
    //Pass director’s name as request parameter
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - deleteDirectorByName
    @DeleteMapping("/delete-director-by-name") // postman done
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteMovAndDire(director);
        return new ResponseEntity<>("delete director and it's movie" , HttpStatus.OK);
    }

    //Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
    //No params or body required
    //Return success message wrapped in a ResponseEntity object
    //Controller Name - deleteAllDirectors
    //(Note that there can be some movies on your watchlist that aren’t mapped
    // to any of the director. Make sure you do not remove them.)
    @DeleteMapping("/delete-all-directors") // postman done
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDi();
        return new ResponseEntity<>("delete all director and movie" , HttpStatus.OK);
    }
}
