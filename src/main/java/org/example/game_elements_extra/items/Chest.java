package org.example.game_elements_extra.items;

import org.example.game_elements.equipment.Weapon;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.actions.IsLootable;

public class Chest implements IsLootable {

    public Item open() {
        return generateLoot();
    }

    public Item generateLoot(){
        return new Weapon("Ivory Battleaxe", 1, null, 6, WeaponType.AXE);
    }

}
