package org.example.game_logic_extra.controllers;

import org.example.game_elements.hero.*;
import org.example.util.services.DisplayService;

import java.util.Scanner;

/**
 * The type Hero creation controller.
 */
public class HeroCreationController {

    /**
     * Create hero hero.
     *
     * @return the hero
     */
    public static Hero createHero(){
        Scanner scanner = new Scanner(System.in);
        DisplayService.displayMessage("Name your character");
        String characterName = scanner.nextLine();
        DisplayService.displayMessage("Choose your class\n");
        DisplayService.displayCommand("1: Warrior, 2: Wizard, 3: Ranger, 4: Rogue");
        int characterClass = scanner.nextInt();

        switch (characterClass) {
            case 1 -> {
                return new Warrior(characterName);
            }
            case 2 -> {
                return new Wizard(characterName);
            }
            case 3 -> {
                return new Ranger(characterName);
            }
            case 4 -> {
                return new Rogue(characterName);
            }
            default -> {
            }
        }
        return null;
    }

}
