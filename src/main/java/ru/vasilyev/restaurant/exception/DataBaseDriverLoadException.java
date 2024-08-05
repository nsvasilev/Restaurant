package ru.vasilyev.restaurant.exception;

public class DataBaseDriverLoadException extends RuntimeException {
    public DataBaseDriverLoadException(String message) {
        super(message);
    }
}