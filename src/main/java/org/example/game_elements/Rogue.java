package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.HPManager;

public class Rogue extends Hero {

    public Rogue(String name){
        super(name);

        this.setLevelUpAttribute(new HeroAttribute(1, 4, 1));
        this.setHp(new HPManager(40));

        // Constraints and prerequisites specific to the Rogue class
        this.validArmorTypes = new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL};
        this.validWeaponTypes = new WeaponType[]{WeaponType.DAGGER, WeaponType.SWORD};
        this.levelAttribute = new HeroAttribute(2, 6, 1);
    }

    public float calculateDamage(){
        Weapon weapon = (Weapon) this.getEquipment().get(Slot.WEAPON);
        int weaponDamage = weapon != null ? weapon.getDamage() : 1;
        return weaponDamage*(1 + this.calculateTotalAttributes().getDexterity()/100.0f);
    }
}
