package com.dupradosantini.bookstore.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID=1;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
