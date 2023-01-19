package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.HPManager;

public class Warrior extends Hero {

    public Warrior(String name){
        super(name);

        this.setLevelUpAttribute(new HeroAttribute(3, 2, 1));
        this.setHp(new HPManager(40));

        // Constraints and prerequisites specific to the Warrior class
        this.validArmorTypes = new ArmorType[]{ArmorType.PLATE, ArmorType.MAIL};
        this.validWeaponTypes = new WeaponType[]{WeaponType.SWORD, WeaponType.AXE, WeaponType.HAMMER};
        this.levelAttribute = new HeroAttribute(5, 2, 1);
    }

    public float calculateDamage(){
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.WEAPON);
        int weaponDamage = weapon != null ? weapon.getDamage() : 1;
        return weaponDamage*(1 + this.calculateTotalAttributes().getStrength()/100.0f);
    }
}
