package com.example.fakeflix.Models.Entities;

import java.util.ArrayList;
import java.util.List;

public final class Catalog {

    private static final Catalog catalog = new Catalog();

    private static List<FeatureFilm> featureFilmList = new ArrayList<>();

    public static List<FeatureFilm> getFeatureFilmList(){
        return featureFilmList;
    }

    public static Catalog getInstance() {
        return catalog;
    }
}
