package com.gtb.quiz.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User id not found: " + userId);
    }
}
