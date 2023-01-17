package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;

public class Wizard extends Hero {

    public Wizard(String name){
        super(name);

        // Constraints and prerequisites specific to the Wizard class
        this.validArmorTypes = new ArmorType[]{ArmorType.CLOTH};
        this.validWeaponTypes = new WeaponType[]{WeaponType.STAFF, WeaponType.WAND};
        this.levelAttribute = new HeroAttribute(1, 1, 8);
    }

    public void levelUp(){
        this.heroLevel += 1;
        this.levelAttribute.increaseAttributes(
                new HeroAttribute(1, 1, 5));
    }

    public float calculateDamage(){
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.WEAPON);
        int weaponDamage = weapon != null ? weapon.getDamage() : 1;
        return weaponDamage*(1 + this.calculateTotalAttributes().getIntelligence()/100.0f);
    }
}
