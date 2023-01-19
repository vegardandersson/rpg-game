package org.example;

import org.example.game_elements.*;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.util.DisplayService;
import org.junit.Assert;
import org.junit.Test;

public class HeroTest {


    // Construction parameter tests for class: Warrior
    @Test
    public void AfterConstruction_Warrior_Level_ShouldBeCorrect(){
        int expectedBaseLevel = 1;
        Hero warrior = new Warrior("warrior");
        Assert.assertEquals(expectedBaseLevel, warrior.getHeroLevel());
    }
    @Test
    public void AfterConstruction_Warrior_Name_ShouldBeCorrect(){
        String expectedName = "warrior";
        Hero warrior = new Warrior("warrior");
        Assert.assertEquals(expectedName, warrior.getHeroName());
    }
    @Test
    public void AfterConstruction_Warrior_LevelAttribute_ShouldBeCorrect(){
        int[] expectedAttributeValues = {5, 2, 1}; //(Strength, Dexterity, Intelligence)
        Hero warrior = new Warrior("warrior");
        Assert.assertEquals(expectedAttributeValues[0], warrior.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedAttributeValues[1], warrior.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedAttributeValues[2], warrior.getLevelAttribute().getIntelligence());
    }



    // Construction parameter tests for class: Wizard
    @Test
    public void AfterConstruction_Wizard_Level_ShouldBeCorrect(){
        int expectedBaseLevel = 1;
        Hero wizard = new Wizard("wizard");
        Assert.assertEquals(expectedBaseLevel, wizard.getHeroLevel());
    }
    @Test
    public void AfterConstruction_Wizard_Name_ShouldBeCorrect(){
        String expectedName = "wizard";
        Hero wizard = new Wizard("wizard");
        Assert.assertEquals(expectedName, wizard.getHeroName());
    }
    @Test
    public void AfterConstruction_Wizard_LevelAttribute_ShouldBeCorrect(){
        int[] expectedAttributeValues = {1, 1, 8}; //(Strength, Dexterity, Intelligence)
        Hero wizard = new Wizard("wizard");
        Assert.assertEquals(expectedAttributeValues[0], wizard.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedAttributeValues[1], wizard.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedAttributeValues[2], wizard.getLevelAttribute().getIntelligence());
    }



    // Construction parameter tests for class: Ranger
    @Test
    public void AfterConstruction_Ranger_Level_ShouldBeCorrect(){
        int expectedBaseLevel = 1;
        Hero ranger = new Ranger("ranger");
        Assert.assertEquals(expectedBaseLevel, ranger.getHeroLevel());
    }
    @Test
    public void AfterConstruction_Ranger_Name_ShouldBeCorrect(){
        String expectedName = "ranger";
        Hero ranger = new Ranger("ranger");
        Assert.assertEquals(expectedName, ranger.getHeroName());
    }
    @Test
    public void AfterConstruction_Ranger_LevelAttribute_ShouldBeCorrect(){
        int[] expectedAttributeValues = {1, 7, 1}; //(Strength, Dexterity, Intelligence)
        Hero ranger = new Ranger("ranger");
        Assert.assertEquals(expectedAttributeValues[0], ranger.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedAttributeValues[1], ranger.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedAttributeValues[2], ranger.getLevelAttribute().getIntelligence());
    }



    // Construction parameter tests for class: Rogue
    @Test
    public void AfterConstruction_Rogue_Level_ShouldBeCorrect(){
        int expectedBaseLevel = 1;
        Hero rogue = new Rogue("rogue");
        Assert.assertEquals(expectedBaseLevel, rogue.getHeroLevel());
    }
    @Test
    public void AfterConstruction_Rogue_Name_ShouldBeCorrect(){
        String expectedName = "rogue";
        Hero rogue = new Rogue("rogue");
        Assert.assertEquals(expectedName, rogue.getHeroName());
    }
    @Test
    public void AfterConstruction_Rogue_LevelAttribute_ShouldBeCorrect(){
        int[] expectedAttributeValues = {2, 6, 1}; //(Strength, Dexterity, Intelligence)
        Hero rogue = new Rogue("rogue");
        Assert.assertEquals(expectedAttributeValues[0], rogue.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedAttributeValues[1], rogue.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedAttributeValues[2], rogue.getLevelAttribute().getIntelligence());
    }



    // Level and LevelAttributes tests after leveling up for class: Warrior
    @Test
    public void AfterLevelingUp_Warrior_Level_ShouldIncreaseCorrectly(){
        int expectedLevelAtLevelFour = 4;
        Hero warrior = new Warrior("warrior");
        for(int i = 0; i < 3; i++){warrior.levelUp();}
        Assert.assertEquals(expectedLevelAtLevelFour, warrior.getHeroLevel());
    }
    @Test
    public void AfterLevelingUp_Warrior_LevelAttribute_ShouldIncreaseCorrectly(){
        int[] expectedLevelAttributeAtLevelFour = {14, 8, 4};
        Hero warrior = new Warrior("warrior");
        for(int i = 0; i < 3; i++){warrior.levelUp();}
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[0], warrior.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[1], warrior.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[2], warrior.getLevelAttribute().getIntelligence());
    }


    // Level and LevelAttributes test after leveling up for class: Wizard
    @Test
    public void AfterLevelingUp_Wizard_Level_ShouldIncreaseCorrectly(){
        int expectedLevelAtLevelFour = 4;
        Hero wizard = new Wizard("wizard");
        for(int i = 0; i < 3; i++){wizard.levelUp();}
        Assert.assertEquals(expectedLevelAtLevelFour, wizard.getHeroLevel());
    }
    @Test
    public void AfterLevelingUp_Wizard_LevelAttribute_ShouldIncreaseCorrectly(){
        int[] expectedLevelAttributeAtLevelFour = {4, 4, 23};
        Hero wizard = new Wizard("wizard");
        for(int i = 0; i < 3; i++){wizard.levelUp();}
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[0], wizard.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[1], wizard.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[2], wizard.getLevelAttribute().getIntelligence());
    }


    // Level and LevelAttributes test after leveling up for class: Ranger
    @Test
    public void AfterLevelingUp_Ranger_Level_ShouldIncreaseCorrectly(){
        int expectedLevelAtLevelFour = 4;
        Hero ranger = new Ranger("ranger");
        for(int i = 0; i < 3; i++){ranger.levelUp();}
        Assert.assertEquals(expectedLevelAtLevelFour, ranger.getHeroLevel());
    }
    @Test
    public void AfterLevelingUp_Ranger_LevelAttribute_ShouldIncreaseCorrectly(){
        int[] expectedLevelAttributeAtLevelFour = {4, 22, 4};
        Hero ranger = new Ranger("ranger");
        for(int i = 0; i < 3; i++){ranger.levelUp();}
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[0], ranger.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[1], ranger.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[2], ranger.getLevelAttribute().getIntelligence());
    }


    // Level and LevelAttributes test after leveling up for class: Rogue
    @Test
    public void AfterLevelingUp_Rogue_Level_ShouldIncreaseCorrectly(){
        int expectedLevelAtLevelFour = 4;
        Hero rogue = new Rogue("rogue");
        for(int i = 0; i < 3; i++){rogue.levelUp();}
        Assert.assertEquals(expectedLevelAtLevelFour, rogue.getHeroLevel());
    }
    @Test
    public void AfterLevelingUp_Rogue_LevelAttribute_ShouldIncreaseCorrectly(){
        int[] expectedLevelAttributeAtLevelFour = {5, 18, 4};
        Hero rogue = new Rogue("rogue");
        for(int i = 0; i < 3; i++){rogue.levelUp();}
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[0], rogue.getLevelAttribute().getStrength());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[1], rogue.getLevelAttribute().getDexterity());
        Assert.assertEquals(expectedLevelAttributeAtLevelFour[2], rogue.getLevelAttribute().getIntelligence());
    }




    // Total Attributes calculation tests
    @Test
    public void TotalAttributesCalculation_NoEquipment_ShouldBeCorrect(){
        int[] expectedTotalAttributes = {5, 2, 1};
        Hero warrior = new Warrior("warrior");
        HeroAttribute actualTotalAttributes = warrior.calculateTotalAttributes();
        Assert.assertEquals(expectedTotalAttributes[0], actualTotalAttributes.getStrength());
        Assert.assertEquals(expectedTotalAttributes[1], actualTotalAttributes.getDexterity());
        Assert.assertEquals(expectedTotalAttributes[2], actualTotalAttributes.getIntelligence());
    }
    @Test
    public void TotalAttributesCalculation_OnePieceOfArmorEquipped_ShouldBeCorrect(){
        int[] expectedTotalAttributes = {7, 3, 2};
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Armor(
                    "plateHelmet", 1, null, 7,
                    new HeroAttribute(2, 1, 1),
                    Slot.HEAD, ArmorType.PLATE));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        HeroAttribute actualTotalAttributes = warrior.calculateTotalAttributes();

        Assert.assertEquals(expectedTotalAttributes[0], actualTotalAttributes.getStrength());
        Assert.assertEquals(expectedTotalAttributes[1], actualTotalAttributes.getDexterity());
        Assert.assertEquals(expectedTotalAttributes[2], actualTotalAttributes.getIntelligence());
    }
    @Test
    public void TotalAttributesCalculation_TwoPiecesOfArmorEquipped_ShouldBeCorrect(){
        int[] expectedTotalAttributes = {12, 5, 3};
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Armor(
                    "plateHelmet", 1, null, 7,
                    new HeroAttribute(2, 1, 1),
                    Slot.HEAD, ArmorType.PLATE));
            warrior.equipItem(new Armor(
                    "plateLeggings", 1, null, 7,
                    new HeroAttribute(5, 2, 1),
                    Slot.LEGS, ArmorType.PLATE));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        HeroAttribute actualTotalAttributes = warrior.calculateTotalAttributes();

        Assert.assertEquals(expectedTotalAttributes[0], actualTotalAttributes.getStrength());
        Assert.assertEquals(expectedTotalAttributes[1], actualTotalAttributes.getDexterity());
        Assert.assertEquals(expectedTotalAttributes[2], actualTotalAttributes.getIntelligence());
    }
    @Test
    public void TotalAttributesCalculation_OverwriteExistingArmorPieceByEquippingNew_ShouldBeCorrect(){
        int[] expectedTotalAttributes = {10, 4, 2};
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Armor(
                    "plateHelmet", 1, null, 7,
                    new HeroAttribute(2, 1, 1),
                    Slot.HEAD, ArmorType.PLATE));
            warrior.equipItem(new Armor(
                    "plateHelmet1", 1, null, 7,
                    new HeroAttribute(5, 2, 1),
                    Slot.HEAD, ArmorType.PLATE));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        HeroAttribute actualTotalAttributes = warrior.calculateTotalAttributes();

        Assert.assertEquals(expectedTotalAttributes[0], actualTotalAttributes.getStrength());
        Assert.assertEquals(expectedTotalAttributes[1], actualTotalAttributes.getDexterity());
        Assert.assertEquals(expectedTotalAttributes[2], actualTotalAttributes.getIntelligence());
    }




    // Damage calculation tests
    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_DefaultDamageWhenNoWeaponEquipped(){
        float expectedDamage = 1.05f;
        Hero warrior = new Warrior("warrior");
        Assert.assertEquals(expectedDamage, warrior.calculateDamage(), 0.0002f);
    }
    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_WeaponEquipped(){
        float expectedDamage = 7.35f;
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Weapon("hammer", 1, null, 7, WeaponType.HAMMER));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(expectedDamage, warrior.calculateDamage(), 0.0002f);
    }
    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_And_OverwrittenNewEquippedWeapon(){
        float expectedDamage = 19.95f;
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Weapon("hammer", 1, null, 7, WeaponType.HAMMER));
            warrior.equipItem(new Weapon("hammer", 1, null, 19, WeaponType.HAMMER));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(expectedDamage, warrior.calculateDamage(), 0.0002f);
    }
    @Test
    public void DamageCalculation_ShouldBeCorrect_BasedOnDamagingAttribute_WithAdditionalArmorAttributes_And_EquippedWeapon(){
        float expectedDamage = 21.28f;
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Armor(
                    "plateHelmet", 1, null, 7,
                    new HeroAttribute(2, 1, 1),
                    Slot.HEAD, ArmorType.PLATE));
            warrior.equipItem(new Armor(
                    "plateLeggings", 1, null, 7,
                    new HeroAttribute(5, 2, 1),
                    Slot.LEGS, ArmorType.PLATE));
            warrior.equipItem(new Weapon("hammer", 1, null, 19, WeaponType.HAMMER));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(expectedDamage, warrior.calculateDamage(), 0.0002f);
    }

    @Test
    public void DisplayService_DisplayHero_WarriorWithWeaponAndArmorEquipped_ShouldReturnCorrectString(){
        String expectedDisplayString = """
                warrior, Level 3


                ---Total attributes---

                Strength: \u001B[31m18\u001B[0m, Dexterity: \u001B[32m9\u001B[0m, Intelligence: \u001B[34m5\u001B[0m


                ---Equipment---

                WEAPON: \u001B[33mhammer\u001B[0m (HAMMER), Damage: \u001B[31m7\u001B[0m
                HEAD: plateHelmet (PLATE), +\u001B[31m2\u001B[0m Strength, +\u001B[32m1\u001B[0m Dexterity, +\u001B[34m1\u001B[0m Intelligence
                BODY: No BODY equipped
                LEGS: plateLeggings (PLATE), +\u001B[31m5\u001B[0m Strength, +\u001B[32m2\u001B[0m Dexterity, +\u001B[34m1\u001B[0m Intelligence
                """;
        Hero warrior = new Warrior("warrior");

        try {
            warrior.equipItem(new Armor(
                    "plateHelmet", 1, null, 7,
                    new HeroAttribute(2, 1, 1),
                    Slot.HEAD, ArmorType.PLATE));
            warrior.equipItem(new Armor(
                    "plateLeggings", 1, null, 7,
                    new HeroAttribute(5, 2, 1),
                    Slot.LEGS, ArmorType.PLATE));
            warrior.equipItem(new Weapon("hammer", 1, null, 7, WeaponType.HAMMER));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < 2; i++){warrior.levelUp();}

        Assert.assertEquals(expectedDisplayString, DisplayService.displayHero(warrior));
    }

}
