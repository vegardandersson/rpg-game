package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {

    private final String heroName;
    public int heroLevel;
    private long exp;
    public HeroAttribute levelAttribute;
    public WeaponType[] validWeaponTypes;
    public ArmorType[] validArmorTypes;
    private Map<Slot, Equipment> equipment;

    public Hero(String name){
        this.heroName = name;
        this.heroLevel = 1;
        this.exp = 0;
        this.equipment = new HashMap<Slot, Equipment>();

        // The equipment map is initialized to be able to hold
        // each slot-type of equipment but have values of null
        // as the character has not equipped anything yet
        this.equipment.put(Slot.WEAPON, null);
        this.equipment.put(Slot.HEAD, null);
        this.equipment.put(Slot.BODY, null);
        this.equipment.put(Slot.LEGS, null);
    }

    public String getHeroName() {
        return heroName;
    }
    public int getHeroLevel() {
        return heroLevel;
    }
    public long getExp() {
        return exp;
    }
    public HeroAttribute getLevelAttribute() {
        return levelAttribute;
    }
    public WeaponType[] getValidWeaponTypes() {
        return validWeaponTypes;
    }
    public ArmorType[] getValidArmorTypes() {
        return validArmorTypes;
    }
    public Map<Slot, Equipment> getEquipment() {
        return equipment;
    }

    public abstract void levelUp();

    public void calculateDamage(){

    }

    public void displayHero(){

    }

    public void equipItem(Equipment item) throws Exception {

    }

}
