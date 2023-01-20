package org.example.game_elements;

import org.example.game_elements.types.Slot;
import org.example.game_elements_extra.Item;

/**
 * Parent class for all types of equipment that
 * a Hero is able to equip. It also extends Item
 * which is a superclass that encapsulates features of
 * all general items
 */
public abstract class Equipment extends Item {

    private final String equipmentName;
    private final int requiredLevel;
    private final HeroAttribute requiredAttributes;
    private Slot eligibleSlot;

    /**
     *
     * @param name The name of the equipment
     * @param level The required level needed to be able to equip the item
     *              Must be a positive integer larger than 0
     * @param attributes The required attributes needed to be able to equip the item
     */
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

    /**
     * Sets eligible slot for equipment item
     * @param eligibleSlot must be one of: HEAD, BODY, LEGS
     */
    public void setEligibleSlot(Slot eligibleSlot) {
        this.eligibleSlot = eligibleSlot;
    }

    /**
     * In order to make Armor-class substitutable with Equipment-class,
     * this method is currently required to be abstract here. Optimally, such
     * unique methods/features should be made into an interface instead,
     * but I left it like this to stay true to the main assignment-requirements,
     * but it unfortunately forces the Weapon-class to implement this method
     * as well which does not adhere to SOLID principle nr. 4
     * @return Returns bonus attributes provided by an armor item
     */
    public abstract HeroAttribute getBonusAttributes();
}
