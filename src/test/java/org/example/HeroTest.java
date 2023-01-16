package org.example;

import org.example.game_elements.Hero;
import org.example.game_elements.Warrior;
import org.example.game_elements.Wizard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

    private Warrior warrior;
    private Wizard wizard;

    @Before
    public void InstantiateHero(){
        this.warrior = new Warrior("defaultWarrior");
        this.wizard = new Wizard("defaultWizard");
    }

    @Test
    public void ConstructHero_OnlyInputName(){
        Assert.assertEquals(1, warrior.getHeroLevel());
    }

}
