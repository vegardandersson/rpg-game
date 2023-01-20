package org.example;

import org.example.game_elements_extra.Enemy;
import org.example.game_elements_extra.Goblin;
import org.junit.Assert;
import org.junit.Test;

public class EnemyTest {


    // Construction parameters of Goblin tests
    @Test
    public void AfterConstruction_Goblin_NameShouldBeCorrect(){
        String expectedName = "Goblin";
        Enemy goblin = new Goblin();
        Assert.assertEquals(expectedName, goblin.getEnemyName());
    }
    @Test
    public void AfterConstruction_Goblin_RewardExpShouldBeCorrect(){
        int expectedExp = 150;
        Enemy goblin = new Goblin();
        Assert.assertEquals(expectedExp, goblin.getRewardExp().getExp());
    }
    @Test
    public void AfterConstruction_Goblin_HpShouldBeCorrect(){
        float expectedHp = 15;
        Enemy goblin = new Goblin();
        Assert.assertEquals(expectedHp, goblin.getHp().getMaxHp(), 0.0002f);
    }
    @Test
    public void AfterConstruction_Goblin_DamageShouldBeCorrect(){
        float expectedDamage = 5;
        Enemy goblin = new Goblin();
        Assert.assertEquals(expectedDamage, goblin.getDamage(), 0.0002f);
    }


    // Calculate damage for Goblin tests
    @Test
    public void CalculateDamage_Goblin_ShouldBeCorrect(){
        float expectedDamage = 5;
        Enemy goblin = new Goblin();
        Assert.assertEquals(expectedDamage, goblin.calculateDamage(), 0.0002f);
    }

}
