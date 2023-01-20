package org.example.util;

/**
 * Custom exception thrown when a Hero does not
 * meet the requirements for equipping a piece of Armor
 */
public class InvalidArmorException extends Exception {
    public InvalidArmorException(String errorMessage){
        super(errorMessage);
    }
}
