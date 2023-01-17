package org.example;

import org.example.game_elements.*;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
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

        try {
            this.warrior.equipItem(new Armor(
                    "plateHelmet", 1, null, 7,
                    new HeroAttribute(2, 1, 1),
                    Slot.HEAD, ArmorType.PLATE));
            this.warrior.equipItem(new Armor(
                    "plateLeggings", 1, null, 7,
                    new HeroAttribute(5, 2, 1),
                    Slot.LEGS, ArmorType.PLATE));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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
    public void TotalAttributesCalculation_ShouldBeCorrect_BasedOnLevel_And_Equipment_Attributes(){
        HeroAttribute totalExpectedAttributes = new HeroAttribute(18, 9, 5);
        for(int i = 0; i < 2; i++){this.warrior.levelUp();}

        HeroAttribute calculatedTotalAttributes = this.warrior.calculateTotalAttributes();
        Assert.assertEquals(totalExpectedAttributes.getStrength(), calculatedTotalAttributes.getStrength());
        Assert.assertEquals(totalExpectedAttributes.getDexterity(), calculatedTotalAttributes.getDexterity());
        Assert.assertEquals(totalExpectedAttributes.getIntelligence(), calculatedTotalAttributes.getIntelligence());
    }

    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_DefaultDamageWhenNoWeaponEquipped(){
        float expectedDamage = 1.18f;

        for(int i = 0; i < 2; i++){this.warrior.levelUp();}

        Assert.assertEquals(expectedDamage, this.warrior.calculateDamage(), 0.0002f);
    }

    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_EquippedWeapon(){
        float expectedDamage = 8.26f;

        try {
            this.warrior.equipItem(new Weapon("hammer", 1, null, 7, WeaponType.HAMMER));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < 2; i++){this.warrior.levelUp();}

        Assert.assertEquals(expectedDamage, this.warrior.calculateDamage(), 0.0002f);
    }

    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_WithAdditionalArmorAttributes_And_EquippedWeapon(){
        float expectedDamage = 33.6f;

        try {
            this.wizard.equipItem(new Weapon("quarterstaff", 1, null, 24, WeaponType.STAFF));
            this.wizard.equipItem(new Armor("clothChest", 1, null, 5,
                    new HeroAttribute(1, 1, 17), Slot.BODY, ArmorType.CLOTH));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < 3; i++){this.wizard.levelUp();}

        Assert.assertEquals(expectedDamage, this.wizard.calculateDamage(), 0.0002f);
    }

}
