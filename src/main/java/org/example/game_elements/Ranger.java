package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.WeaponType;

public class Ranger extends Hero {

    public Ranger(String name){
        super(name);

        // Constraints and prerequisites specific to the Ranger class
        this.validArmorTypes = new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL};
        this.validWeaponTypes = new WeaponType[]{WeaponType.BOW};
        this.levelAttribute = new HeroAttribute(1, 7, 1);
    }

    public void levelUp(){

    }
}
