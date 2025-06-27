package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    @Override
    public List<Movie> findAll() {
        return Arrays.asList(
            new Movie("Inception", "Christopher Nolan", 2010),
            new Movie("Interstellar", "Christopher Nolan", 2014),
            new Movie("The Matrix", "Lana Wachowski, Lilly Wachowski", 1999)
        );
    }
}
