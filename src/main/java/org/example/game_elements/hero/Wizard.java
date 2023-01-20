package org.example.game_elements.hero;

import org.example.game_elements.HeroAttribute;
import org.example.game_elements.equipment.Weapon;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.stat_managers.HPManager;

/**
 * Concrete implementation of Hero class named Wizard
 * Represents the rgp-game style class Wizard
 * CalculateDamage() is derived from being a combatant (IsCombatant)
 * which the parent Hero class gets from the interface but does not concretely implement
 * as each rpg class has its own way of damaging
 */
public class Wizard extends Hero {

    /**
     * @param name Name of hero, passed on to parent constructor
     */
    public Wizard(String name){
        super(name);

        this.setLevelUpAttribute(new HeroAttribute(1, 1, 5)); // Sets how much attribute values should increase when leveling
        this.setHp(new HPManager(40));                                                  // Sets starting hp at level 1

        // Constraints and prerequisites specific to the Wizard class
        this.validArmorTypes = new ArmorType[]{ArmorType.CLOTH};
        this.validWeaponTypes = new WeaponType[]{WeaponType.STAFF, WeaponType.WAND};
        this.levelAttribute = new HeroAttribute(1, 1, 8);
    }

    /**
     * Calculates total damage that a hero will deal when attacking an enemy
     * Calculation is based on the following concept:
     * Total damage is WeaponDamage increased by 1% per each value-point in Hero-class' damaging attribute
     * Damaging attribute for Wizard: Intelligence
     * @return total damage as a float value
     */
    public float calculateDamage(){
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.WEAPON);

        // If hero has no weapon equipped, damage is taken to be 1
        int weaponDamage = weapon != null ? weapon.getDamage() : 1;

        return weaponDamage*(1 + this.calculateTotalAttributes().getIntelligence()/100.0f);
    }
}
