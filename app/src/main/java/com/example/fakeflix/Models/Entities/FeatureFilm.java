package com.example.fakeflix.Models.Entities;

import android.graphics.drawable.Drawable;

import com.example.fakeflix.Controllers.Movie;
import java.io.Serializable;

public class FeatureFilm extends Movie implements Serializable {

    private static final long serialVersionID = 1L;

    private String synopsis;

    public FeatureFilm(Integer id, String name, Drawable featureImage, String synopsis) {
        super(id, name, featureImage);
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
