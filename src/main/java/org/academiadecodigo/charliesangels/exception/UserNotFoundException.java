package org.academiadecodigo.charliesangels.exception;

public class UserNotFoundException extends QuenchException {

    public UserNotFoundException() {
        super("User not found");
    }
}
