package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.EXPManager;
import org.example.game_elements_extra.HPManager;
import org.example.util.InvalidWeaponException;

import java.util.*;

public abstract class Hero {

    private final String heroName;
    public int heroLevel;
    private EXPManager exp;
    private HPManager hp;
    public HeroAttribute levelAttribute;
    public WeaponType[] validWeaponTypes;
    public ArmorType[] validArmorTypes;
    private Map<Slot, Equipment> equipment;

    public Hero(String name){
        this.heroName = name;
        this.heroLevel = 1;
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

    public HeroAttribute calculateTotalAttributes(){
        List<HeroAttribute> allAttributeSources = new ArrayList<>();
        allAttributeSources.add(this.levelAttribute);
        for(Slot slot : Slot.values()){
            if(slot != Slot.WEAPON && this.equipment.get(slot) != null){
                allAttributeSources.add(this.equipment.get(slot).getBonusAttributes());
            }
        }
        return HeroAttribute.getSumOfAttributes(allAttributeSources);
    }

    public abstract void levelUp();

    public abstract float calculateDamage();

    public void equipItem(Equipment item) throws Exception {
        if(item.getEligibleSlot() == Slot.WEAPON){
            this.equipWeapon((Weapon) item);
        }else{
            this.equipArmor((Armor) item);
        }
    }

    private void equipWeapon(Weapon item) throws Exception {
        if(item.getRequiredLevel() > this.heroLevel){
            throw new InvalidWeaponException("Hero level too low, failed to equip");
        }
        if(!Arrays.asList(this.validWeaponTypes).contains(item.getWeaponType())){
            throw new InvalidWeaponException("Hero is ineligible to use this type of weapon, failed to equip");
        }
        this.equipment.put(item.getEligibleSlot(), item);
    }

    private void equipArmor(Armor item) throws Exception {
        if(item.getRequiredLevel() > this.heroLevel){
            throw new InvalidWeaponException("Hero level too low, failed to equip");
        }
        if(!Arrays.asList(this.validArmorTypes).contains(item.getArmorType())){
            throw new InvalidWeaponException("Hero is ineligible to use this type of armor, failed to equip");
        }
        this.equipment.put(item.getEligibleSlot(), item);
    }

}
