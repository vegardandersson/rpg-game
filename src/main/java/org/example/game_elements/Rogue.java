package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.HPManager;

/**
 * Concrete implementation of Hero class named Rogue
 * Represents the rgp-game style class Rogue
 * CalculateDamage() is derived from being a combatant (IsCombatant)
 * which the parent Hero class gets from the interface but does not concretely implement
 * as each rpg class has its own way of damaging
 */
public class Rogue extends Hero {

    /**
     * @param name Name of hero, passed on to parent constructor
     */
    public Rogue(String name){
        super(name);

        this.setLevelUpAttribute(new HeroAttribute(1, 4, 1)); // Sets how much attribute values should increase when leveling
        this.setHp(new HPManager(40));                                                  // Sets starting hp at level 1

        // Constraints and prerequisites specific to the Rogue class
        this.validArmorTypes = new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL};
        this.validWeaponTypes = new WeaponType[]{WeaponType.DAGGER, WeaponType.SWORD};
        this.levelAttribute = new HeroAttribute(2, 6, 1);
    }

    /**
     * Calculates total damage that a hero will deal when attacking an enemy
     * Calculation is based on the following concept:
     * Total damage is WeaponDamage increased by 1% per each value-point in Hero-class' damaging attribute
     * Damaging attribute for Rogue: Dexterity
     * @return total damage as a float value
     */
    public float calculateDamage(){
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.WEAPON);

        // If hero has no weapon equipped, damage is taken to be 1
        int weaponDamage = weapon != null ? weapon.getDamage() : 1;

        return weaponDamage*(1 + this.calculateTotalAttributes().getDexterity()/100.0f);
    }
}
