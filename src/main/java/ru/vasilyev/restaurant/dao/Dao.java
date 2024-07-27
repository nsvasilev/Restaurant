package ru.vasilyev.restaurant.dao;

import java.util.Optional;

public interface Dao<T, K> {
    T save(T t);

    void update(T t);

    boolean deleteById(K id);

    Optional<T> findById(K id);
}