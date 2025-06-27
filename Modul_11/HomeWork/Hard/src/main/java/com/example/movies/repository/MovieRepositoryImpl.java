package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final List<Movie> movies = new ArrayList<>();

    public MovieRepositoryImpl() {
        movies.add(new Movie("Inception", "Christopher Nolan", 2010));
        movies.add(new Movie("Interstellar", "Christopher Nolan", 2014));
        movies.add(new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", 1999));
        movies.add(new Movie("Dunkirk", "Christopher Nolan", 2017));
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public List<Movie> findByDirector(String director) {
        return movies.stream()
                .filter(m -> m.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.toList());
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
