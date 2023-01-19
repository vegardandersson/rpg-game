package org.example;

import org.example.game_elements.*;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EquipmentTest {

    private Hero warrior;
    private Hero ranger;

    private Equipment hammer;
    private Equipment hammerTooHighLevel;

    private Equipment plateHelmet;
    private Equipment plateHelmetTooHighLevel;

    @Before
    public void instantiate(){
        this.warrior = new Warrior("defaultWarrior");
        this.ranger = new Ranger("defaultRanger");

        this.hammer = new Weapon("hammer", 1, null, 7, WeaponType.HAMMER);
        this.hammerTooHighLevel = new Weapon("hammer", 6, null, 7, WeaponType.HAMMER);

        this.plateHelmet = new Armor(
                "plateHelmet", 1, null, 7,
                new HeroAttribute(2, 1, 1),
                Slot.HEAD, ArmorType.PLATE);
        this.plateHelmetTooHighLevel = new Armor(
                "plateHelmet", 3, null, 7,
                new HeroAttribute(4, 2, 1),
                Slot.HEAD, ArmorType.PLATE);
    }


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



    @Test
    public void EquipHammerWeapon_Warrior_ShouldSucceed_And_BeAddedToHeroEquipment(){
        try {
            this.warrior.equipItem(this.hammer);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(this.hammer, this.warrior.getEquipment().get(Slot.WEAPON));
    }

    @Test
    public void EquipHammerWrongTypeWeapon_Ranger_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        try {
            this.ranger.equipItem(this.hammer);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertNull(this.ranger.getEquipment().get(Slot.WEAPON));
    }

    @Test
    public void EquipHammerTooHighLevelWeapon_Warrior_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        try {
            this.warrior.equipItem(this.hammerTooHighLevel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertNull(this.warrior.getEquipment().get(Slot.WEAPON));
    }

    @Test
    public void EquipPlateHelmetArmor_Warrior_ShouldSucceed_And_BeAddedToHeroEquipment_In_CorrectSlot(){
        try {
            this.warrior.equipItem(this.plateHelmet);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(this.plateHelmet, this.warrior.getEquipment().get(Slot.HEAD));
        Assert.assertNull(this.warrior.getEquipment().get(Slot.BODY));
    }

    @Test
    public void EquipPlateHelmetWrongTypeArmor_Ranger_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        try {
            this.ranger.equipItem(this.plateHelmet);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertNull(this.ranger.getEquipment().get(Slot.HEAD));
    }

    @Test
    public void EquipPlateHelmetTooHighLevelArmor_Warrior_ShouldThrowException_And_NotBeAddedToHeroEquipment(){
        try {
            this.warrior.equipItem(this.plateHelmetTooHighLevel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assert.assertNull(this.warrior.getEquipment().get(Slot.HEAD));
    }

}
