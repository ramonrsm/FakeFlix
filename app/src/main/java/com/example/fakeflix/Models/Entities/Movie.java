package com.example.fakeflix.Models.Entities;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.fakeflix.Models.Enums.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

    private static final long serialVersionID = 1L;

    private Integer        id;
    private String         name;
    private String         synopsis;
    private Drawable       fetureImage;
    private List<Category> categoryList = new ArrayList<>();

    public Movie() {
    }

    public Movie(Integer id, String name, String synopsis, Drawable fetureImage) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
        this.fetureImage = fetureImage;
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    public List<Category> findAllCategories(){
        return categoryList;
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

    public Drawable getFetureImage() {
        return fetureImage;
    }

    public void setFetureImage(Drawable fetureImage) {
        this.fetureImage = fetureImage;
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

        StringBuilder categories = new StringBuilder();

        for (Category catgory : categoryList) {
            categories.append(catgory.toString()).append(", ");
        }

        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", categoryList='"+ categories.toString() + '\'' +
                '}';
    }
}
