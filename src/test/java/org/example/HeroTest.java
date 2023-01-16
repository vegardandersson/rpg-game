package org.example;

import org.example.game_elements.Hero;
import org.example.game_elements.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

    private Warrior warrior;

    @Before
    public void InstantiateHero(){
        this.warrior = new Warrior("defaultName");
    }

    @Test
    public void ConstructHero_OnlyInputName(){
        Assert.assertEquals(1, warrior.getHeroLevel());
    }

}
