package org.example;

import org.example.game_elements.*;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements.types.WeaponType;
import org.example.util.InvalidWeaponException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EquipmentTest {

    private Warrior warrior;
    private Ranger ranger;

    private Weapon hammer;
    private Weapon hammerTooHighLevel;

    private Armor plateHelmet;
    private Armor plateHelmetTooHighLevel;

    @Before
    public void instantiate(){
        this.warrior = new Warrior("defaultWarrior");
        this.ranger = new Ranger("defaultRanger");

        this.hammer = new Weapon("hammer", 1, null, 7, WeaponType.HAMMER);
        this.hammerTooHighLevel = new Weapon("hammer", 6, null, 7, WeaponType.HAMMER);

        this.plateHelmet = new Armor("plateHelmet", 1, null, 7, Slot.HEAD, ArmorType.PLATE);
        this.plateHelmetTooHighLevel = new Armor("plateHelmet", 3, null, 7, Slot.HEAD, ArmorType.PLATE);
    }

    @Test
    public void ConstructWeapon_ShouldHaveCorrectLevelRequirement(){
        int baseLevel = 1;
        Assert.assertEquals(this.hammer.getRequiredLevel(), baseLevel);
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
