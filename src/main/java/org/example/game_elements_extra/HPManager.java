package org.example.game_elements_extra;

/**
 * The type Hp manager.
 */
public class HPManager {

    private float maxHp;
    private float currentHp;

    /**
     * Instantiates a new Hp manager.
     *
     * @param hp the hp
     */
    public HPManager(float hp){
        this.maxHp = hp;
        this.currentHp = maxHp;
    }

    /**
     * Gets current hp.
     *
     * @return the current hp
     */
    public float getCurrentHp() {
        return currentHp;
    }

    /**
     * Sets current hp.
     *
     * @param hp the hp
     */
    public void setCurrentHp(float hp) {
        this.currentHp = hp;
    }

    /**
     * Gets max hp.
     *
     * @return the max hp
     */
    public float getMaxHp() {
        return maxHp;
    }

    /**
     * Sets max hp.
     *
     * @param maxHp the max hp
     */
    public void setMaxHp(float maxHp) {
        this.maxHp = maxHp;
    }

    /**
     * Reduce current hp boolean.
     *
     * @param damage the damage
     * @return the boolean
     */
    public boolean reduceCurrentHp(float damage){
        this.currentHp -= damage;
        return this.currentHp <= 0;
    }

    /**
     * Increase current hp.
     *
     * @param healing the healing
     */
    public void increaseCurrentHp(float healing){
        this.currentHp += healing;
        if(this.currentHp > this.maxHp){this.currentHp = this.maxHp;}
    }

    /**
     * Increase max hp.
     *
     * @param increase the increase
     */
    public void increaseMaxHp(float increase){
        this.maxHp += increase;
    }

    /**
     * Replenish hp.
     */
    public void replenishHp(){
        this.currentHp = this.maxHp;
    }
}
