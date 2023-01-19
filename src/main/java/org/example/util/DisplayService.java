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

import java.io.PrintWriter;

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


    public static void displayMessage(String message){
        System.out.println("\n" + message + "\n");
    }

    public static void displayError(String message){
        DisplayService.displayMessage(COLOR_RED + message + COLOR_RESET);
    }

    public static void displayCommand(String message){
        DisplayService.displayMessage(COLOR_CYAN + message + COLOR_RESET);
    }

    public static void displayWorld(WorldGrid world, int[] heroPosition){

        String enemyIcon = COLOR_RED + " X " + COLOR_RESET;
        String chestIcon = COLOR_YELLOW + " C " + COLOR_RESET;
        String heroIcon = COLOR_GREEN + " 0 " + COLOR_RESET;
        String exitIcon = COLOR_BLUE + " E " + COLOR_RESET;
        String emptyIcon = " + ";

        StringBuilder builder = new StringBuilder();

        WorldObjectType[][] worldGrid = world.getWorldGrid();
        int gridDimension = world.getGridDimension();

        for(int i = 0; i < gridDimension; i++){
            for(int j = 0; j < gridDimension; j++){
                if(heroPosition != null && i == heroPosition[0] && j == heroPosition[1]){
                    builder.append(heroIcon);
                }else {
                    if (worldGrid[i][j] == null) {
                        builder.append(emptyIcon);
                    } else {
                        switch (worldGrid[i][j]){
                            case ENEMY -> builder.append(enemyIcon);
                            case CHEST -> builder.append(chestIcon);
                            case EXIT -> builder.append(exitIcon);
                        }
                    }
                }
            }
            System.out.println(builder);
            builder = new StringBuilder();
        }
        System.out.println("Floor: " + COLOR_WHITE + world.getFloorNumber());
    }

    public static String displayItem(Item item){
        return item.toString();
    }

    public static String displayHero(Hero hero){

        StringBuilder builder = new StringBuilder();
        builder.append(hero.getHeroName() + ", Level " +hero.getHeroLevel() + "\n\n\n");

        HeroAttribute totalAttributes = hero.calculateTotalAttributes();
        builder.append("---Total attributes---\n\n");
        builder.append("Strength: " + COLOR_RED + totalAttributes.getStrength() + COLOR_RESET);
        builder.append(", Dexterity: " + COLOR_GREEN + totalAttributes.getDexterity() + COLOR_RESET);
        builder.append(", Intelligence: " + COLOR_BLUE + totalAttributes.getIntelligence() + COLOR_RESET);
        builder.append("\n\n\n");

        builder.append("---Equipment---\n\n");

        Weapon weapon = (Weapon) hero.getEquipment().get(Slot.WEAPON);
        builder.append(Slot.WEAPON.name() + ": ");
        builder.append(weapon == null ? "No " + Slot.WEAPON.name() + " equipped"
                : COLOR_YELLOW + weapon.getEquipmentName() +
                COLOR_RESET + " (" + weapon.getWeaponType() + "), Damage: " +
                COLOR_RED + weapon.getDamage() + COLOR_RESET);
        builder.append("\n");


        for(Slot slot : Slot.values()){
            if(slot != Slot.WEAPON) {
                Armor armor = (Armor) hero.getEquipment().get(slot);
                HeroAttribute bonusAttributes = armor == null ? null : armor.getBonusAttributes();
                builder.append(slot.name() + ": ");
                builder.append(armor == null ? "No " + slot.name() + " equipped"
                        : armor.getEquipmentName() + " (" + armor.getArmorType() + "), +" +
                        DisplayService.COLOR_RED + bonusAttributes.getStrength() +
                        DisplayService.COLOR_RESET + " Strength, +" +
                        DisplayService.COLOR_GREEN + bonusAttributes.getDexterity() +
                        DisplayService.COLOR_RESET + " Dexterity, +" +
                        DisplayService.COLOR_BLUE + bonusAttributes.getIntelligence() +
                        DisplayService.COLOR_RESET + " Intelligence");
                builder.append("\n");
            }
        }

        return builder.toString();

    }

}
