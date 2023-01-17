package org.example.game_elements_extra;

public class Goblin extends Enemy {

    public Goblin(){
        super("Goblin", 150, 15f, 5);
    }
    public float attack() {
        return this.getDamage();
    }

}
