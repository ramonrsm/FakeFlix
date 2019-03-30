package com.example.fakeflix.Models.Entities;

import com.example.fakeflix.Controllers.Movie;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<FeatureFilm> featureFilmList;

    private static final Catalog ourInstance = new Catalog();

    public static Catalog getInstance() {
        return ourInstance;
    }

    private Catalog() {
        featureFilmList = new ArrayList<>();
    }

    public List<FeatureFilm> getFeatureFilmList(){
        return featureFilmList;
    }

    public void add(FeatureFilm featureFilm){
        featureFilmList.add(featureFilm);
    }

    public FeatureFilm get(int index){
        return featureFilmList.get(index);
    }
}
