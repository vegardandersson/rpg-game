package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
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

    public int calculateDamage(){
        return 0;
    }
}
