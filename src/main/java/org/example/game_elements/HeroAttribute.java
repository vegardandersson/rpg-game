package org.example.game_elements;

import java.util.List;

/**
 * Class that holds values for attributes: Strength, Dexterity and Intelligence
 * General and can be utilized by any object that makes use of such attributes
 */
public class HeroAttribute {

    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(){
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
    }
    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Takes a supplied collection of attribute values (HeroAttribute)
     * and increases own attribute values based on these
     * @param attributes HeroAttribute object holding attribute values
     *                   to increase with
     */
    public void increaseAttributes(HeroAttribute attributes){
        this.strength += attributes.getStrength();
        this.dexterity += attributes.getDexterity();
        this.intelligence += attributes.getIntelligence();
    }

    /**
     * Utility method statically available from this class
     * that is used to add HeroAttributes together by repeatedly
     * calling the increaseAttributes() method on a result object
     * @param attributes List of HeroAttributes to be summed
     * @return A HeroAttribute object that holds the total summed values for each attribute
     */
    public static HeroAttribute getSumOfAttributes(List<HeroAttribute> attributes){
        HeroAttribute sum = new HeroAttribute();
        for (HeroAttribute attribute : attributes) {
            sum.increaseAttributes(attribute);
        }
        return sum;
    }
}
