package org.example.game_elements_extra;

import org.example.game_elements.Weapon;
import org.example.game_elements.types.WeaponType;

public class Chest implements IsLootable {

    public Item open() {
        return generateLoot();
    }

    public Item generateLoot(){
        return new Weapon("Ivory Battleaxe", 1, null, 6, WeaponType.AXE);
    }

}
