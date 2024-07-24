package com.expenses.main.exceptions;

public class RecordNotFoundException extends Exception {

    public RecordNotFoundException() { super(); }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public RecordNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
