package org.example;

import org.example.game_elements_extra.HPManager;
import org.junit.Assert;
import org.junit.Test;

public class HPManagerTest {

    // Construction parameters for HPManager tests
    @Test
    public void AfterConstruction_HPManager_MaxHpShouldBeCorrect(){
        float expectedHp = 75;
        HPManager hpManager = new HPManager(75);
        Assert.assertEquals(expectedHp, hpManager.getMaxHp(), 0.0002f);
    }
    @Test
    public void AfterConstruction_HPManager_CurrentHpShouldBeCorrect(){
        float expectedHp = 75;
        HPManager hpManager = new HPManager(75);
        Assert.assertEquals(expectedHp, hpManager.getCurrentHp(), 0.0002f);
    }


    // Core manipulation methods for HPManager tests
    @Test
    public void AfterReducingHp_HPManager_CurrentHpShouldBeCorrectlyReduced(){
        float expectedHp = 40;
        HPManager hpManager = new HPManager(75);
        hpManager.reduceCurrentHp(35);
        Assert.assertEquals(expectedHp, hpManager.getCurrentHp(), 0.0002f);
    }
    @Test
    public void AfterReducingHpBelowZero_HPManager_ShouldReturnTrue(){
        HPManager hpManager = new HPManager(75);
        Assert.assertTrue(hpManager.reduceCurrentHp(80));
    }
    @Test
    public void AfterIncreasingCurrentHp_HPManager_CurrentHpShouldBeCorrectlyIncreased(){
        float expectedHp = 75;
        HPManager hpManager = new HPManager(75);
        hpManager.reduceCurrentHp(35);
        hpManager.increaseCurrentHp(35);
        Assert.assertEquals(expectedHp, hpManager.getCurrentHp(), 0.0002f);
    }
    @Test
    public void AfterIncreasingCurrentHpAboveMaxHp_HPManager_CurrentHpShouldBeCorrectlyCappedToEqualMaxHp(){
        float expectedHp = 75;
        HPManager hpManager = new HPManager(75);
        hpManager.increaseCurrentHp(200);
        Assert.assertEquals(expectedHp, hpManager.getMaxHp(), 0.0002f);
    }
    @Test
    public void AfterIncreasingMaxHp_HPManager_MaxHpShouldBeCorrectlyIncreased(){
        float expectedHp = 120;
        HPManager hpManager = new HPManager(75);
        hpManager.increaseMaxHp(45);
        Assert.assertEquals(expectedHp, hpManager.getMaxHp(), 0.0002f);
    }
    @Test
    public void AfterReplenishingHp_HPManager_CurrentHpShouldCorrectlyMatchMaxHp(){
        float expectedHp = 75;
        HPManager hpManager = new HPManager(75);
        hpManager.reduceCurrentHp(60);
        hpManager.replenishHp();
        Assert.assertEquals(expectedHp, hpManager.getCurrentHp(), 0.0002f);
    }

}
