package org.example.game_elements;

import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.util.DisplayService;

public class Weapon extends Equipment {

    private int damage;
    private final WeaponType weaponType;

    public Weapon(String name, int level, HeroAttribute attributes, int damage, WeaponType weaponType){
        super(name, level, attributes);
        this.damage = damage;
        this.setEligibleSlot(Slot.WEAPON);
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

    public HeroAttribute getBonusAttributes(){return null;}

    @Override
    public String toString(){
        return DisplayService.COLOR_YELLOW + this.getEquipmentName() +
                DisplayService.COLOR_RESET + " (" + this.getWeaponType() + "), Damage: " +
                DisplayService.COLOR_RED + this.getDamage() +DisplayService.COLOR_RESET;
    }
}
