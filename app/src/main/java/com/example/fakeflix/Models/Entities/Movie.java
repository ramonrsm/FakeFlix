package com.example.fakeflix.Models.Entities;

import com.example.fakeflix.Models.Enums.Category;
import java.io.Serializable;
import java.net.URL;

public class Movie implements Serializable {

    private static final long serialVersionID = 1L;

    private Integer        id;
    private String         name;
    private String         synopsis;
    private URL            fetureImage;
    private Category       category;

    public Movie() {
    }

    public Movie(Integer id, String name, String synopsis, URL fetureImage, Category category) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
        this.fetureImage = fetureImage;
        this.category = category;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public URL getFetureImage() {
        return fetureImage;
    }

    public void setFetureImage(URL fetureImage) {
        this.fetureImage = fetureImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", fetureImage=" + fetureImage +
                ", category=" + category +
                '}';
    }
}
