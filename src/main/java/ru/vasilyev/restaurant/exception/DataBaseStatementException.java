package ru.vasilyev.restaurant.exception;

public class DataBaseStatementException extends RuntimeException {
    public DataBaseStatementException(String message) {
        super(message);
    }
}