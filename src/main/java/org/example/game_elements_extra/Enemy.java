package org.example.game_elements_extra;

public abstract class Enemy implements EnemyActions {

    private final String enemyName;
    private final EXPManager rewardExp;
    private HPManager hp;
    private final float damage;

    public Enemy(String name, int exp, float hp, float damage){
        this.enemyName = name;
        this.rewardExp = new EXPManager(exp);
        this.hp = new HPManager(hp);
        this.damage = damage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public EXPManager getRewardExp() {
        return rewardExp;
    }
    public HPManager getHp(){
        return hp;
    }

    public float getDamage() {
        return damage;
    }
}
