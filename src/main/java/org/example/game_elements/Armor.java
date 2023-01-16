package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;

public class Armor extends Equipment {

    private int defense;
    private final HeroAttribute bonusAttributes;
    private final ArmorType armorType;

    public Armor(String name, int level, HeroAttribute attributes, int defense, HeroAttribute bonusAttributes, Slot slot, ArmorType armorType){
        super(name, level, attributes);
        this.defense = defense;
        this.bonusAttributes = bonusAttributes;
        this.setEligibleSlot(slot);
        this.armorType = armorType;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public HeroAttribute getBonusAttributes() {
        return bonusAttributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}
