package org.example.game_elements_extra;

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

    public void increaseExp(int exp){
        this.exp += exp;
    }
    public void increaseExp(EXPManager exp){
        this.exp += exp.getExp();
    }
}
