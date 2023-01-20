package org.example.game_elements_extra;

/**
 * The interface Is lootable.
 */
public interface IsLootable {

    /**
     * Open item.
     *
     * @return the item
     */
    public Item open();

    /**
     * Generate loot item.
     *
     * @return the item
     */
    public Item generateLoot();

}
