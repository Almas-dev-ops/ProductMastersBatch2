package com.example.movies.repository;

import com.example.movies.model.Movie;
import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
    List<Movie> findByDirector(String director);
}
