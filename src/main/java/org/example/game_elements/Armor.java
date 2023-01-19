package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.util.DisplayService;

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

    @Override
    public String toString(){
        return this.getEquipmentName() + " (" + this.getArmorType() + ", " + this.getEligibleSlot().name() + "), +" +
                DisplayService.COLOR_RED + bonusAttributes.getStrength() +
                DisplayService.COLOR_RESET + " Strength, +" +
                DisplayService.COLOR_GREEN + bonusAttributes.getDexterity() +
                DisplayService.COLOR_RESET + " Dexterity, +" +
                DisplayService.COLOR_BLUE + bonusAttributes.getIntelligence() +
                DisplayService.COLOR_RESET + " Intelligence";
    }
}
