package org.example.game_elements_extra.actions;

/**
 * The interface Is combatant.
 */
public interface IsCombatant {

    /**
     * Calculate damage float.
     *
     * @return the float
     */
    public float calculateDamage();

    /**
     * Receive damage boolean.
     *
     * @param damage the damage
     * @return the boolean
     */
    public boolean receiveDamage(float damage);

}
