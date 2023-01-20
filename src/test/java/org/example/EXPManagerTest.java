package org.example;

import org.example.game_elements.Hero;
import org.example.game_elements.Warrior;
import org.example.game_elements_extra.EXPManager;
import org.junit.Assert;
import org.junit.Test;

public class EXPManagerTest {


    // Construction parameters for EXPManager tests
    @Test
    public void AfterConstruction_EXPManager_UsingDefaultConstructor_ExpShouldBeCorrect(){
        int expectedExp = 1;
        EXPManager expManager = new EXPManager();
        Assert.assertEquals(expectedExp, expManager.getExp());
    }
    @Test
    public void AfterConstruction_EXPManager_WithExp_ExpShouldBeCorrect(){
        int expectedExp = 1200;
        EXPManager expManager = new EXPManager(1200);
        Assert.assertEquals(expectedExp, expManager.getExp());
    }
    @Test
    public void AfterConstruction_EXPManager_ExpThresholdsForLevelingUp_ShouldBeCorrect(){
        int[] expectedThresholds = {250, 700, 1500, 3000, 6000, 12000};
        EXPManager expManager = new EXPManager();
        Assert.assertArrayEquals(expectedThresholds, expManager.getLevelThresholds());
    }


    // Core manipulation methods for EXPManager tests
    @Test
    public void AfterIncreasingExp_EXPManager_ExpShouldBeCorrectlyIncreased(){
        int expectedExp = 150;
        EXPManager expManager = new EXPManager(100);
        expManager.increaseExp(new EXPManager(50));
        Assert.assertEquals(expectedExp, expManager.getExp());
    }
    @Test
    public void AfterIncreasingExpForHero_ThatShouldLeadToLevelUp_ExpManager_HeroShouldLevelUp(){
        int expectedLevel = 2;
        Hero warrior = new Warrior("warrior");
        EXPManager expToIncrease = new EXPManager(300);
        warrior.getExp().increaseExp(expToIncrease, warrior);
        Assert.assertEquals(expectedLevel, warrior.getHeroLevel());
    }

}
