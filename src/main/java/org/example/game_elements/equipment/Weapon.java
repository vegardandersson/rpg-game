package org.example.game_elements.equipment;

import org.example.game_elements.HeroAttribute;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.util.services.DisplayService;

/**
 * Class for Equipment of type Weapon
 * that a hero can equip in the weapon slot
 * to increase damage
 */
public class Weapon extends Equipment {

    private int damage;
    private final WeaponType weaponType;

    /**
     *
     * @param name The name of the equipment, sent to parent constructor
     * @param level The required level needed to be able to equip this item, sent to parent constructor
     *              Must be a positive integer larger than 0
     * @param attributes The required attributes needed to be able to equip this item, sent to parent constructor
     * @param damage Flat damage stat of weapon
     * @param weaponType The type of the weapon item
     */
    public Weapon(String name, int level, HeroAttribute attributes, int damage, WeaponType weaponType){
        super(name, level, attributes);
        this.damage = damage;
        this.setEligibleSlot(Slot.WEAPON);  // Weapon can only be wielded in Slot of type Weapon
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public WeaponType getWeaponType(){
        return this.weaponType;
    }

    /**
     * Wasteful implementation that Weapon is forced to do.
     * Equipment/Armor class should be redesigned to not cause this
     * or Weapon should be made to also be able to supply bonus attributes
     * which is not unthinkable in a rpg setting
     * @return null
     */
    public HeroAttribute getBonusAttributes(){return null;}

    @Override
    public String toString(){
        return DisplayService.COLOR_YELLOW + this.getEquipmentName() +
                DisplayService.COLOR_RESET + " (" + this.getWeaponType() + "), Damage: " +
                DisplayService.COLOR_RED + this.getDamage() +DisplayService.COLOR_RESET;
    }
}
