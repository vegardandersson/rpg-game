package org.example.game_logic;

import org.example.game_elements.Hero;
import org.example.util.DisplayService;

public class GameController {

    private Hero hero;

    public void startGame(){
        this.setHero(HeroCreationController.createHero());
        System.out.println("Success!\n\n");
        System.out.println(DisplayService.displayHero(this.hero));
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
