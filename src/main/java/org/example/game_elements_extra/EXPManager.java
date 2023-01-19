package org.example.game_elements_extra;

import org.example.game_elements.Hero;

public class EXPManager {

    private int exp;
    private final int[] levelThresholds = {250, 700, 1500, 3000, 6000, 12000};


    public EXPManager(){
        this.exp = 1;
    }
    public EXPManager(int exp){
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void increaseExp(EXPManager exp, Hero hero){
        int currentThreshold = getCurrentExpThreshold();
        this.exp += exp.getExp();
        if(getCurrentExpThreshold() > currentThreshold){
            hero.levelUp();
        }
    }

    private int getCurrentExpThreshold(){
        int threshold = 0;
        for (int levelThreshold : this.levelThresholds) {
            threshold += this.exp > levelThreshold ? 1 : 0;
        }
        return threshold;
    }
}
