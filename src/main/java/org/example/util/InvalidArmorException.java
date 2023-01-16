package org.example.util;

public class InvalidArmorException extends Exception {
    public InvalidArmorException(String errorMessage){
        super(errorMessage);
    }
}
