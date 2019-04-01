package com.example.fakeflix.Controllers;

import com.example.fakeflix.Models.Entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalog implements Catalog<Movie, Integer> {

    private static final MovieCatalog Instance = new MovieCatalog();

    private List<Movie> movieList = new ArrayList<>();

    public static MovieCatalog getInstance() {
        return Instance;
    }

    @Override
    public void save(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public void delete(Movie movie) {
        movieList.remove(movie);
    }

    @Override
    public Movie findById(Integer id) {

        for (Movie movie: movieList) {
            if(movie.getId().equals(id)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return movieList;
    }
}
