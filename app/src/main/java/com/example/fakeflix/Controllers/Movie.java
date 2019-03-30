package com.example.fakeflix.Controllers;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.Objects;

public abstract class Movie implements Serializable {

    private static final long serialVersionID = 1L;

    private Integer      id;
    private String       name;
    private Drawable     featureImage;

    public Movie(Integer id, String name, Drawable featureImage) {
        this.id = id;
        this.name = name;
        this.featureImage = featureImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(Drawable featureImage) {
        this.featureImage = featureImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getId(), movie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
