package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.WeaponType;

public class Rogue extends Hero {

    public Rogue(String name){
        super(name);

        // Constraints and prerequisites specific to the Rogue class
        this.validArmorTypes = new ArmorType[]{ArmorType.LEATHER, ArmorType.MAIL};
        this.validWeaponTypes = new WeaponType[]{WeaponType.DAGGER, WeaponType.SWORD};
        this.levelAttribute = new HeroAttribute(2, 6, 1);
    }

    public void levelUp(){
        this.heroLevel += 1;
        this.levelAttribute.increaseAttributes(
                new HeroAttribute(1, 4, 1));
    }

    public float calculateDamage(){
        return 0;
    }
}
