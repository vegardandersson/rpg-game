package org.example;

import org.example.game_elements_extra.enemy.Enemy;
import org.example.game_elements_extra.enemy.Goblin;
import org.example.game_elements_extra.actions.IsCombatant;
import org.junit.Assert;
import org.junit.Test;

public class IsCombatantTest {


    // Combat actions for combatant: Goblin  tests
    @Test
    public void CalculatingDamage_Goblin_ShouldBeCorrectBasedOnDamage(){
        float expectedDamage = 5;
        IsCombatant goblin = new Goblin();
        Assert.assertEquals(expectedDamage, goblin.calculateDamage(), 0.0002f);
    }
    @Test
    public void AfterReceivingDamage_Goblin_HpShouldBeCorrectlyReduced(){
        float expectedHp = 10;
        Enemy goblin = new Goblin();
        goblin.receiveDamage(5);
        Assert.assertEquals(expectedHp, goblin.getHp().getCurrentHp(), 0.0002f);
    }
}
