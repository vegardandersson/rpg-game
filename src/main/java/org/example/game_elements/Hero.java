package org.example.game_elements;

import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.EXPManager;
import org.example.game_elements_extra.HPManager;
import org.example.game_elements_extra.IsCombatant;
import org.example.util.DisplayService;
import org.example.util.InvalidArmorException;
import org.example.util.InvalidWeaponException;

import java.util.*;

public abstract class Hero implements IsCombatant {

    private final String heroName;
    public int heroLevel;

    // *extra
    private EXPManager exp;                 // Hero's exp (Experience points) managed by EXPManager
    // *extra
    private HPManager hp;                   // Hero's hp (hit points) managed by HPManager

    public HeroAttribute levelAttribute;    // HeroAttribute object which holds total values of attributes gained from leveling

    // Instead of having to concretely implement the method
    // levelUp() in all child classes of Hero, instead we use
    // a levelUpAttribute which defines how much the
    // levelAttributes should increase for each level
    public HeroAttribute levelUpAttribute;

    public WeaponType[] validWeaponTypes;   // Array of enumerator values of WeaponType defining which weapon types the hero can use
    public ArmorType[] validArmorTypes;     // Array of enumerator values of ArmorType defining which armor types the hero can use
    private Map<Slot, Equipment> equipment; // HashMap that holds all Equipment objects that the hero equips

    public Hero(String name){
        this.heroName = name;

        this.heroLevel = 1;           // All heroes start at level 1
        this.exp = new EXPManager();  // Using default constructor, which starts at 1 exp

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
    public EXPManager getExp(){return exp;} // *extra
    public HPManager getHp() { return hp; } // *extra

    public void setHp(HPManager hp) {
        this.hp = hp;
    } // *extra

    public HeroAttribute getLevelAttribute() {
        return levelAttribute;
    }

    public HeroAttribute getLevelUpAttribute() {
        return levelUpAttribute;
    }

    public void setLevelUpAttribute(HeroAttribute levelUpAttribute) {
        this.levelUpAttribute = levelUpAttribute;
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

    /**
     * Method calculates total attributes of hero by combining levelAttributes
     * gained from increasing hero level and all bonus attributes gained
     * by wearing pieces of Armor that provides bonus attributes
     * @return HeroAttribute object that holds total values for all attributes
     */
    public HeroAttribute calculateTotalAttributes(){

        // We first use a List that will hold all HeroAttribute objects that will contribute to the total
        List<HeroAttribute> allAttributeSources = new ArrayList<>();

        // We add the levelAttribute to this list
        allAttributeSources.add(this.levelAttribute);

        // We then loop through each unique slot type and check
        // whether the hero's equipment HashMap holds any Equipment for given slot
        // and if so, adds its potential bonus attributes to the collection
        // *Weapon is ignored as it cannot have bonus attributes
        for(Slot slot : Slot.values()){
            if(slot != Slot.WEAPON && this.equipment.get(slot) != null){
                allAttributeSources.add(this.equipment.get(slot).getBonusAttributes());
            }
        }

        return HeroAttribute.getSumOfAttributes(allAttributeSources);
    }

    /**
     * The levelUp() function can either be called manually
     * or be called automatically when a Hero reaches a certain exp threshold,
     * The method increments the heroLevel by 1,
     * increases the levelAttributes by one instance of the levelUpAttributes,
     * increases maximum hp of hero to be able to survive longer
     */
    public void levelUp(){
        this.levelAttribute.increaseAttributes(this.levelUpAttribute);
        this.heroLevel += 1;
        this.getHp().increaseMaxHp(20); // *extra
        this.getHp().replenishHp(); // we replenish hp to make sure hero is fully healed when leveling up

        DisplayService.displayMessage("\nYou increased to level " +
                DisplayService.COLOR_GREEN + this.heroLevel +
                DisplayService.COLOR_RESET + "!\n");
    }

    /**
     * Hero is a combatant and can therefore receive damage
     * The method reduces the heroes current hp based on
     * incoming damage from an attacker
     * @param damage The damage that an attacker deals
     *               Must be a positive number
     * @return True means character has died
     *          False means character is alive
     */
    public boolean receiveDamage(float damage){
        return this.hp.reduceCurrentHp(damage);
    } // *extra

    /**
     * General method for equipping equipment
     * which checks type of equipment and chooses
     * appropriate equipment-method based on this type
     * @param item Equipment item to be equipped
     * @throws Exception either InvalidWeapon or InvalidArmor
     *                  exception based on type of equipment supplied
     */
    public void equipItem(Equipment item) throws Exception {

        // In our simple application, we only need to check if the
        // equipment has slot type Weapon or not to determine if it
        // is of type Armor or type Weapon
        if(item.getEligibleSlot() == Slot.WEAPON){
            this.equipWeapon((Weapon) item);
        }else{
            this.equipArmor((Armor) item);
        }
    }

    /**
     * Attempts to equip a Weapon
     * If successful, Weapon Object is added to
     * hero equipment HashMap in the Weapon Slot key
     * @param item Equipment item of type Weapon to be equipped
     * @throws Exception Throws InvalidWeaponException if Weapon has either
     *                  too high level requirement based on hero level or
     *                  wrong WeaponType based on what WeaponTypes a hero can use
     */
    private void equipWeapon(Weapon item) throws Exception {

        // If hero is too low level based on Weapon requirement, we throw exception
        if(item.getRequiredLevel() > this.heroLevel){
            throw new InvalidWeaponException("Hero level too low, failed to equip");
        }

        // If Weapon type is not found in hero's legal weapon types, we throw exception
        if(!Arrays.asList(this.validWeaponTypes).contains(item.getWeaponType())){
            throw new InvalidWeaponException("Hero is ineligible to use this type of weapon, failed to equip");
        }

        // If no exception is thrown, we add Weapon to equipment HashMap in correct key/slot, overwriting existing Equipment
        this.equipment.put(item.getEligibleSlot(), item);
    }

    /**
     * Attempts to equip a piece of Armor
     * If successful, Armor Object is added to
     * hero equipment HashMap in the Slot key corresponding
     * to the Armor objects defined, eligible slot
     * @param item Equipment item of type Armor to be equipped
     * @throws Exception Throws InvalidArmorException if Armor has either
     *                  too high level requirement based on hero level or
     *                  wrong ArmorType based on what ArmorTypes a hero can use
     */
    private void equipArmor(Armor item) throws Exception {

        // If hero is too low level based on Armor requirement, we throw exception
        if(item.getRequiredLevel() > this.heroLevel){
            throw new InvalidArmorException("Hero level too low, failed to equip");
        }

        // If Armor type is not found in hero's legal armor types, we throw exception
        if(!Arrays.asList(this.validArmorTypes).contains(item.getArmorType())){
            throw new InvalidArmorException("Hero is ineligible to use this type of armor, failed to equip");
        }

        // If no exception is thrown, we Armor to equipment HashMap in correct key/slot, overwriting existing Equipment
        this.equipment.put(item.getEligibleSlot(), item);
    }

}
