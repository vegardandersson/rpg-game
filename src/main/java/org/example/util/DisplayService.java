package org.example.util;

import org.example.game_elements.Armor;
import org.example.game_elements.Hero;
import org.example.game_elements.HeroAttribute;
import org.example.game_elements.Weapon;
import org.example.game_elements.types.ArmorType;
import org.example.game_elements.types.Slot;
import org.example.game_elements_extra.Item;
import org.example.game_elements_extra.WorldGrid;
import org.example.game_elements_extra.types.WorldObjectType;

public class DisplayService {

    // Color codes for basic ANSI console colorscheme of 8 colors
    // COLOR_RESET is used to clear the assigned color during a string concatenation,
    // which makes it possible to use several distinct colors in one String object
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";

    public static void displayWorld(WorldGrid world, Hero hero){
        StringBuilder builder = new StringBuilder();

        WorldObjectType[][] worldGrid = world.getWorldGrid();
        int gridDimension = world.getGridDimension();

        for(int i = 0; i < gridDimension; i++){
            for(int j = 0; j < gridDimension; j++){
                if(worldGrid[i][j] == null){
                    builder.append("NULL ");
                }else {
                    builder.append(worldGrid[i][j].name());
                }
            }
            System.out.println(builder);
            builder = new StringBuilder();
        }
    }

    public static String displayItem(Item item){
        return item.toString();
    }

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
        builder.append(weapon == null ? "No " + Slot.WEAPON.name() + " equipped"
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
