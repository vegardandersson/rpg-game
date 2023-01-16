package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.WeaponType;

public class Warrior extends Hero {

    public Warrior(String name){
        super(name);

        // Constraints and prerequisites specific to the Warrior class
        this.validArmorTypes = new ArmorType[]{ArmorType.PLATE, ArmorType.MAIL};
        this.validWeaponTypes = new WeaponType[]{WeaponType.SWORD, WeaponType.AXE, WeaponType.HAMMER};
        this.levelAttribute = new HeroAttribute(5, 2, 1);
    }

    public void levelUp(){
        this.heroLevel += 1;
        this.levelAttribute.increaseAttributes(
                new HeroAttribute(3, 2, 1));
    }
}
