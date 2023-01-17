package org.example.util;

import org.example.game_elements.Armor;
import org.example.game_elements.Hero;
import org.example.game_elements.HeroAttribute;
import org.example.game_elements.Weapon;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;

public class DisplayService {

    public static String displayHero(Hero hero){

        StringBuilder builder = new StringBuilder();
        builder.append(hero.getHeroName() + ", Level " +hero.getHeroLevel() + "\n\n\n");

        HeroAttribute totalAttributes = hero.calculateTotalAttributes();
        builder.append("---Total attributes---\n\n");
        builder.append("Strength: " + totalAttributes.getStrength());
        builder.append(", Dexterity: " + totalAttributes.getDexterity());
        builder.append(", Intelligence: " + totalAttributes.getIntelligence());
        builder.append("\n\n\n");

        builder.append("---Equipment---\n\n");

        Weapon weapon = (Weapon) hero.getEquipment().get(Slot.WEAPON);
        builder.append(Slot.WEAPON.name() + ": ");
        builder.append(weapon == null ? "No weapon equipped"
                : weapon.getEquipmentName() + " (" + weapon.getWeaponType() + "), Damage: " + weapon.getDamage());
        builder.append("\n");


        for(Slot slot : Slot.values()){
            if(slot != Slot.WEAPON) {
                Armor armor = (Armor) hero.getEquipment().get(slot);
                HeroAttribute bonusAttributes = armor == null ? null : armor.getBonusAttributes();
                builder.append(slot.name() + ": ");
                builder.append(armor == null ? "No " + slot.name() + " equipped"
                        : armor.getEquipmentName() + " (" + armor.getArmorType() + "), +" +
                        bonusAttributes.getStrength() + " Strength, +" +
                        bonusAttributes.getDexterity() + " Dexterity, +" +
                        bonusAttributes.getIntelligence() + " Intelligence");
                builder.append("\n");
            }
        }

        return builder.toString();

    }

}
