package org.example.game_elements_extra;

import org.example.game_elements.Hero;

/**
 * The type Exp manager.
 */
public class EXPManager {

    private int exp;
    private final int[] levelThresholds = {250, 700, 1500, 3000, 6000, 12000};


    /**
     * Instantiates a new Exp manager.
     */
    public EXPManager(){
        this.exp = 1;
    }

    /**
     * Instantiates a new Exp manager.
     *
     * @param exp the exp
     */
    public EXPManager(int exp){
        this.exp = exp;
    }

    /**
     * Gets exp.
     *
     * @return the exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * Sets exp.
     *
     * @param exp the exp
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * Get level thresholds int [ ].
     *
     * @return the int [ ]
     */
    public int[] getLevelThresholds() { return levelThresholds; }

    /**
     * Increase exp.
     *
     * @param exp  the exp
     * @param hero the hero
     */
    public void increaseExp(EXPManager exp, Hero hero){
        int currentThreshold = getCurrentExpThreshold();
        this.exp += exp.getExp();
        if(getCurrentExpThreshold() > currentThreshold){
            hero.levelUp();
        }
    }

    /**
     * Increase exp.
     *
     * @param exp the exp
     */
    public void increaseExp(EXPManager exp){
        this.exp += exp.getExp();
    }

    private int getCurrentExpThreshold(){
        int threshold = 0;
        for (int levelThreshold : this.levelThresholds) {
            threshold += this.exp > levelThreshold ? 1 : 0;
        }
        return threshold;
    }
}
