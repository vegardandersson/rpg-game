package org.example;

import org.example.game_elements.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {

    private Hero warrior;
    private Hero wizard;
    private Hero ranger;
    private Hero rogue;

    @Before
    public void InstantiateHero(){
        this.warrior = new Warrior("defaultWarrior");
        this.wizard = new Wizard("defaultWizard");
        this.ranger = new Ranger("defaultRanger");
        this.rogue = new Rogue("defaultRogue");
    }

    @Test
    public void AfterConstruction_LevelShouldBeOne(){
        Assert.assertEquals(1, this.warrior.getHeroLevel());
    }

    @Test
    public void AfterConstruction_LevelAttribute_ShouldMatchClassAndLevel(){
        HeroAttribute warriorBaseLevelAttribute = new HeroAttribute(5, 2, 1);
        HeroAttribute wizardBaseLevelAttribute = new HeroAttribute(1, 1, 8);
        Assert.assertEquals(warriorBaseLevelAttribute.getStrength(), this.warrior.getLevelAttribute().getStrength());
        Assert.assertEquals(wizardBaseLevelAttribute.getStrength(), this.wizard.getLevelAttribute().getStrength());
    }

    @Test
    public void AfterLevelingUp_LevelAttribute_ShouldIncreaseCorrectly(){
        HeroAttribute rangerLevelAttributeAtLevelFour = new HeroAttribute(4, 22, 4);
        HeroAttribute rogueLevelAttributeAtLevelThree = new HeroAttribute(4, 14, 3);

        for(int i = 0; i < 3; i++){this.ranger.levelUp();}
        for(int i = 0; i < 2; i++){this.rogue.levelUp();}

        Assert.assertEquals(4, this.ranger.getHeroLevel());
        Assert.assertEquals(3, this.rogue.getHeroLevel());

        Assert.assertEquals(rangerLevelAttributeAtLevelFour.getDexterity(), this.ranger.getLevelAttribute().getDexterity());
        Assert.assertEquals(rogueLevelAttributeAtLevelThree.getIntelligence(), this.rogue.getLevelAttribute().getIntelligence());
    }

    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_DefaultDamageWhenNoWeaponEquipped(){

    }

    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_EquippedWeapon(){

    }

}
