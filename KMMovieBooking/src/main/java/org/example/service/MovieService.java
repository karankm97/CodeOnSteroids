package org.example.service;

import org.example.exception.NotFoundException;
import org.example.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    Map<String, Movie> movies;

    public MovieService() {
        movies = new HashMap<>();
    }

    public String createMovie(String name, String genre, Integer durationInSeconds) {
        String movieId = UUID.randomUUID().toString();
        Movie newMovie = new Movie(movieId, name, genre, durationInSeconds);
        movies.put(movieId, newMovie);
        return movieId;
    }

    public Movie getMovie(String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new NotFoundException();
        }
        return movies.get(movieId);
    }
}
