package org.example.game_elements_extra;

public class HPManager {

    private float maxHp;
    private float currentHp;

    public HPManager(float hp){
        this.maxHp = hp;
        this.currentHp = maxHp;
    }

    public float getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(float hp) {
        this.currentHp = hp;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(float maxHp) {
        this.maxHp = maxHp;
    }

    public void reduceCurrentHp(float damage){
        this.currentHp -= damage;
    }

    public void increaseCurrentHp(float healing){
        this.currentHp += healing;
        if(this.currentHp > this.maxHp){this.currentHp = this.maxHp;}
    }

    public void increaseMaxHp(float increase){
        this.maxHp += increase;
    }
}
