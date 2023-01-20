package org.example.game_elements_extra;

/**
 * The type Enemy.
 */
public abstract class Enemy implements IsCombatant {

    private final String enemyName;
    private final EXPManager rewardExp;
    private HPManager hp;
    private final float damage;

    /**
     * Instantiates a new Enemy.
     *
     * @param name   the name
     * @param exp    the exp
     * @param hp     the hp
     * @param damage the damage
     */
    public Enemy(String name, int exp, float hp, float damage){
        this.enemyName = name;
        this.rewardExp = new EXPManager(exp);
        this.hp = new HPManager(hp);
        this.damage = damage;
    }

    /**
     * Gets enemy name.
     *
     * @return the enemy name
     */
    public String getEnemyName() {
        return enemyName;
    }

    /**
     * Gets reward exp.
     *
     * @return the reward exp
     */
    public EXPManager getRewardExp() {
        return rewardExp;
    }

    /**
     * Get hp hp manager.
     *
     * @return the hp manager
     */
    public HPManager getHp(){
        return hp;
    }

    /**
     * Gets damage.
     *
     * @return the damage
     */
    public float getDamage() {
        return damage;
    }

    public float calculateDamage() {
        return damage;
    }

    public boolean receiveDamage(float damage){
        return this.hp.reduceCurrentHp(damage);
    }
}
