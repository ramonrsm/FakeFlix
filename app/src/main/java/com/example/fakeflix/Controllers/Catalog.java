package com.example.fakeflix.Controllers;

import java.util.List;

public interface Catalog<T, ID> {

    void save(T obj);
    void delete(T obj);
    T findById(ID id);
    List<T> findAll();
}
