package com.example.mystars.database;

import java.util.List;

public interface ICrud<T> {
    boolean add(T item);
    boolean update(T item);
    boolean delete(T item);
    T findById(int id);
    List<T> getAll();
}