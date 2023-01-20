package org.example;

import org.example.game_elements.*;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.util.InvalidArmorException;
import org.example.util.InvalidWeaponException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EquipmentTest {



    // Construction parameter tests for Equipment of type: Weapon
    @Test
    public void ConstructWeapon_ShouldHaveCorrect_WeaponName(){
        String expectedWeaponName = "weapon";
        Equipment weapon = new Weapon("weapon", 3, null, 11, WeaponType.SWORD);
        Assert.assertEquals(expectedWeaponName, weapon.getEquipmentName());
    }
    @Test
    public void ConstructWeapon_ShouldHaveCorrect_LevelRequirement(){
        int expectedLevelRequirement = 3;
        Equipment weapon = new Weapon("weapon", 3, null, 11, WeaponType.SWORD);
        Assert.assertEquals(expectedLevelRequirement, weapon.getRequiredLevel());
    }
    @Test
    public void ConstructWeapon_ShouldHaveCorrect_SlotRequirement(){
        Slot expectedSlotRequirement = Slot.WEAPON;
        Equipment weapon = new Weapon("weapon", 3, null, 11, WeaponType.SWORD);
        Assert.assertEquals(expectedSlotRequirement, weapon.getEligibleSlot());
    }
    @Test
    public void ConstructWeapon_ShouldHaveCorrect_WeaponType(){
        WeaponType expectedWeaponType = WeaponType.SWORD;
        Weapon weapon = new Weapon("weapon", 3, null, 11, WeaponType.SWORD);
        Assert.assertEquals(expectedWeaponType, weapon.getWeaponType());
    }
    @Test
    public void ConstructWeapon_ShouldHaveCorrect_WeaponDamage(){
        int expectedWeaponDamage = 11;
        Weapon weapon = new Weapon("weapon", 3, null, 11, WeaponType.SWORD);
        Assert.assertEquals(expectedWeaponDamage, weapon.getDamage());
    }



    // Construction parameter tests for Equipment of type: Armor
    @Test
    public void ConstructArmor_ShouldHaveCorrect_ArmorName(){
        String expectedArmorName = "plateHelmet";
        Equipment armor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Assert.assertEquals(expectedArmorName, armor.getEquipmentName());
    }
    @Test
    public void ConstructArmor_ShouldHaveCorrect_LevelRequirement(){
        int expectedLevelRequirement = 1;
        Equipment armor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Assert.assertEquals(expectedLevelRequirement, armor.getRequiredLevel());
    }
    @Test
    public void ConstructArmor_ShouldHaveCorrect_SlotRequirement(){
        Slot expectedSlotRequirement = Slot.HEAD;
        Equipment armor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Assert.assertEquals(expectedSlotRequirement, armor.getEligibleSlot());
    }
    @Test
    public void ConstructArmor_ShouldHaveCorrect_ArmorType(){
        ArmorType expectedArmorType = ArmorType.PLATE;
        Armor armor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Assert.assertEquals(expectedArmorType, armor.getArmorType());
    }
    @Test
    public void ConstructArmor_ShouldHaveCorrect_ArmorAttributes(){
        int[] expectedArmorAttributes = {2, 1, 1};
        Armor armor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Assert.assertEquals(expectedArmorAttributes[0], armor.getBonusAttributes().getStrength());
        Assert.assertEquals(expectedArmorAttributes[1], armor.getBonusAttributes().getDexterity());
        Assert.assertEquals(expectedArmorAttributes[2], armor.getBonusAttributes().getIntelligence());
    }



    // Equipping Weapon tests
    @Test
    public void EquipWeapon_Warrior_ShouldSucceed_And_BeAddedToHeroEquipment(){
        Equipment expectedWeapon = new Weapon("weapon", 1, null, 11, WeaponType.SWORD);
        Hero warrior = new Warrior("warrior");
        try {
            warrior.equipItem(expectedWeapon);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(expectedWeapon, warrior.getEquipment().get(Slot.WEAPON));
    }
    @Test
    public void EquipWrongTypeWeapon_Ranger_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        Equipment expectedWeapon = new Weapon("weapon", 1, null, 11, WeaponType.SWORD);
        Hero ranger = new Ranger("ranger");
        try {
            ranger.equipItem(expectedWeapon);
        }catch (Exception e){
            Assert.assertEquals(InvalidWeaponException.class, e.getClass());
            System.out.println(e.getMessage());
        }
        Assert.assertNull(ranger.getEquipment().get(Slot.WEAPON));
    }
    @Test
    public void EquipTooHighLevelWeapon_Warrior_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        Equipment expectedWeapon = new Weapon("weapon", 3, null, 11, WeaponType.SWORD);
        Hero warrior = new Warrior("warrior");
        try {
            warrior.equipItem(expectedWeapon);
        }catch (Exception e){
            Assert.assertEquals(InvalidWeaponException.class, e.getClass());
            System.out.println(e.getMessage());
        }
        Assert.assertNull(warrior.getEquipment().get(Slot.WEAPON));
    }




    // Equip Armor tests
    @Test
    public void EquipArmor_Warrior_ShouldSucceed_And_BeAddedToHeroEquipment_In_CorrectSlot(){
        Equipment expectedArmor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Hero warrior = new Warrior("warrior");
        try {
            warrior.equipItem(expectedArmor);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(expectedArmor, warrior.getEquipment().get(Slot.HEAD));
    }
    @Test
    public void EquipWrongTypeArmor_Ranger_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        Equipment expectedArmor = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Hero ranger = new Ranger("ranger");
        try {
            ranger.equipItem(expectedArmor);
        }catch (Exception e){
            Assert.assertEquals(InvalidArmorException.class, e.getClass());
            System.out.println(e.getMessage());
        }
        Assert.assertNull(ranger.getEquipment().get(Slot.HEAD));
    }
    @Test
    public void EquipTooHighLevelArmor_Warrior_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        Equipment expectedArmor = new Armor(
                "plateHelmet", 2, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        Hero warrior = new Warrior("warrior");
        try {
            warrior.equipItem(expectedArmor);
        }catch (Exception e){
            Assert.assertEquals(InvalidArmorException.class, e.getClass());
            System.out.println(e.getMessage());
        }
        Assert.assertNull(warrior.getEquipment().get(Slot.HEAD));
    }

}
