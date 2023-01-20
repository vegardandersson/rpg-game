package org.example;

import org.example.game_elements.equipment.Equipment;
import org.example.game_elements.equipment.Weapon;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.items.Chest;
import org.example.game_elements_extra.actions.IsLootable;
import org.junit.Assert;
import org.junit.Test;

public class IsLootableTest {


    // IsLootable methods for concrete implementation Chest tests
    @Test
    public void AfterGeneratingLoot_Chest_CorrectItemShouldBeReturned(){
        Equipment expectedItemLoot = new Weapon("Ivory Battleaxe", 1, null, 6, WeaponType.AXE);
        IsLootable chest = new Chest();
        Assert.assertEquals(expectedItemLoot.getClass(), chest.generateLoot().getClass());
    }
    @Test
    public void AfterOpening_Chest_CorrectItemShouldBeReturned(){
        Equipment expectedItemLoot = new Weapon("Ivory Battleaxe", 1, null, 6, WeaponType.AXE);
        IsLootable chest = new Chest();
        Assert.assertEquals(expectedItemLoot.getClass(), chest.open().getClass());
    }

}
