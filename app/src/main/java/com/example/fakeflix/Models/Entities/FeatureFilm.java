package com.example.fakeflix.Models.Entities;

import java.io.Serializable;
import java.util.Objects;

public class FeatureFilm implements Serializable {

    private static final long serialVersionID = 1L;

    private Integer      id;
    private String       name;
    private String       synopsis;

    public FeatureFilm() {
    }

    public FeatureFilm(Integer id, String name, String synopsis) {
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeatureFilm)) return false;
        FeatureFilm that = (FeatureFilm) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "FeatureFilm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
