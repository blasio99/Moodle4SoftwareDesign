package dev.blasio99.moodle.server.exception;

public class UserExistsException extends Exception {

    public UserExistsException() {
        super();
    }

    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

