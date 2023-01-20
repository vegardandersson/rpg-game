package org.example;

import org.example.game_elements.Equipment;
import org.example.game_elements.Weapon;
import org.example.game_elements.types.WeaponType;
import org.example.game_elements_extra.Chest;
import org.example.game_elements_extra.IsLootable;
import org.example.game_elements_extra.Item;
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
