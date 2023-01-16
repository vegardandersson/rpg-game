package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;

public class Armor extends Equipment {

    private int defense;
    private ArmorType armorType;

    public Armor(String name, int level, HeroAttribute attributes, int defense, Slot slot, ArmorType armorType){
        super(name, level, attributes);
        this.defense = defense;
        this.setEligibleSlot(slot);
        this.armorType = armorType;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}
