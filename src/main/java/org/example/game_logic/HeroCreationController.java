package org.example.game_logic;

import org.example.game_elements.*;

import java.util.Scanner;

public class HeroCreationController {

    public static Hero createHero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name your character");
        String characterName = scanner.nextLine();
        System.out.println("Choose your class\n");
        System.out.println("1: Warrior, 2: Wizard, 3: Ranger, 4: Rogue");
        int characterClass = scanner.nextInt();

        switch (characterClass){
            case 1: return new Warrior(characterName);
            case 2: return new Wizard(characterName);
            case 3: return new Ranger(characterName);
            case 4: return new Rogue(characterName);
            default: break;
        }
        return null;
    }

}
