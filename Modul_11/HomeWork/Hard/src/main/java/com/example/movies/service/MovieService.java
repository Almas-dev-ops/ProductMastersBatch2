package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.findByDirector(director);
    }

    public void addMovie(Movie movie) {
        validateMovie(movie);
        movieRepository.addMovie(movie);
    }

    private void validateMovie(Movie movie) {
        if (movie.getTitle() == null || movie.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (movie.getDirector() == null || movie.getDirector().trim().isEmpty()) {
            throw new IllegalArgumentException("Director must not be empty");
        }
        if (movie.getYear() < 1900) {
            throw new IllegalArgumentException("Year must be 1900 or later");
        }
    }
}
