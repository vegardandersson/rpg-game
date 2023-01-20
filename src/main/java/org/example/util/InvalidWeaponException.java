package org.example.util;

/**
 * Custom exception thrown when a hero does not
 * meet the requirements for equipping a Weapon
 */
public class InvalidWeaponException extends Exception {
    public InvalidWeaponException(String errorMessage){
        super(errorMessage);
    }
}
