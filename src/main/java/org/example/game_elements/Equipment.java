package org.example.game_elements;

import org.example.game_elements.types.Slot;

public abstract class Equipment {

    private final String equipmentName;
    private final int requiredLevel;
    private final HeroAttribute requiredAttributes;
    private Slot eligibleSlot;

    public Equipment(String name, int level, HeroAttribute attributes){
        this.equipmentName = name;
        this.requiredLevel = level;
        this.requiredAttributes = attributes;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public HeroAttribute getRequiredAttributes() {
        return requiredAttributes;
    }

    public Slot getEligibleSlot() {
        return eligibleSlot;
    }

    public void setEligibleSlot(Slot eligibleSlot) {
        this.eligibleSlot = eligibleSlot;
    }

    public abstract HeroAttribute getBonusAttributes();
}
