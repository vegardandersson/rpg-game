package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.util.DisplayService;

/**
 * Class for equipment of type Armor
 * that a Hero can equip in eligible armor
 * slots to provide bonus attributes and defense
 */
public class Armor extends Equipment {

    private int defense; // *extra
    private final HeroAttribute bonusAttributes;
    private final ArmorType armorType;

    /**
     *
     * @param name The name of the equipment, sent to parent constructor
     * @param level The required level needed to be able to equip this item, sent to parent constructor
     *              Must be a positive integer larger than 0
     * @param attributes The required attributes needed to be able to equip this item, sent to parent constructor
     * @param defense The amount of defensive stats this armor item provides when equipped
     * @param bonusAttributes The amount of bonus attributes this armor item provides when equipped
     * @param slot The equipment slot in which this item is to be worn in
     *             Armor can be equipped in slots: HEAD, BODY, LEGS
     * @param armorType The type of the armor item
     */
    public Armor(String name, int level, HeroAttribute attributes, int defense, HeroAttribute bonusAttributes, Slot slot, ArmorType armorType){
        super(name, level, attributes);
        this.defense = defense;
        this.bonusAttributes = bonusAttributes;
        this.setEligibleSlot(slot);
        this.armorType = armorType;
    }

    public int getDefense() {return defense;}  // *extra

    public void setDefense(int defense) {
        this.defense = defense;
    }  // *extra

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
