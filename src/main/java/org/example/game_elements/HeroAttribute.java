package org.example.game_elements;

import java.util.List;

public class HeroAttribute {

    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(){
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
    }
    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void increaseAttributes(HeroAttribute attributes){
        this.strength += attributes.getStrength();
        this.dexterity += attributes.getDexterity();
        this.intelligence += attributes.getIntelligence();
    }

    public static HeroAttribute getSumOfAttributes(List<HeroAttribute> attributes){
        HeroAttribute sum = new HeroAttribute();
        for (HeroAttribute attribute : attributes) {
            sum.increaseAttributes(attribute);
        }
        return sum;
    }
}
