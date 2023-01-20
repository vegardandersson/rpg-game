package org.example.util.services;

import org.example.game_elements.equipment.Armor;
import org.example.game_elements.hero.Hero;
import org.example.game_elements.HeroAttribute;
import org.example.game_elements.equipment.Weapon;
import org.example.game_elements.types.Slot;
import org.example.game_elements_extra.items.Item;
import org.example.game_elements_extra.WorldGrid;
import org.example.game_elements_extra.types.WorldObjectType;


/**
 * Class that is responsible for handling console printing
 * that is related to the flow of game. It includes methods for printing
 * generic messages, error-codes, commands as well as Hero and item display
 * It makes use of ANSI console colorscheme in order to print in color
 */
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

    /**
     * Standard message output method for displaying
     * generic, custom game messages
     * @param message Message to display
     */
    public static void displayMessage(String message){
        System.out.println("\n" + message + "\n");
    }

    /**
     * Standard error output method for displaying
     * error messages related to the game.
     * Will display the errormessage as color RED
     * @param message Errormessage to display
     */
    public static void displayError(String message){
        DisplayService.displayMessage(COLOR_RED + message + COLOR_RESET);
    }

    /**
     * Standard command output method for displaying
     * commands the player can issue during play.
     * Will display the command/input message as CYAN
     * @param message
     */
    public static void displayCommand(String message){
        DisplayService.displayMessage(COLOR_CYAN + message + COLOR_RESET);
    }

    /**
     * This can be thought of as the main graphical
     * interface of the game. The method, when called,
     * displays the status of the game world by considering each
     * entry in the world grid array as an individual pixel/object
     * and then prints, line by line, all of these pixels/objects
     * to create a graphical view of the game world.
     * Each unique game world object (ENEMY, CHEST, PLAYER, EXIT, EMPTY SQUARE)
     * has its own graphical symbol.
     * @param world an instance of a game world of type WorldGrid
     * @param heroPosition the position of the hero in the game world
     *                     represented as a 2 dimensional coordinate in the form
     *                     of a 1 dimensional array with two entries
     *                     for x and y respectively
     */
    public static void displayWorld(WorldGrid world, int[] heroPosition){

        // Unique graphical(textual in this case) symbols for each type of world grid object
        String enemyIcon = COLOR_RED + " X " + COLOR_RESET;
        String chestIcon = COLOR_YELLOW + " C " + COLOR_RESET;
        String heroIcon = COLOR_GREEN + " 0 " + COLOR_RESET;
        String exitIcon = COLOR_BLUE + " E " + COLOR_RESET;
        String emptyIcon = " + "; // represents world grid square with no special content

        StringBuilder builder = new StringBuilder();

        WorldObjectType[][] worldGrid = world.getWorldGrid();
        int gridDimension = world.getGridDimension();


        for(int i = 0; i < gridDimension; i++){

            // For each row of the world grid, we build a line of symbol of the contents
            // of each square and then display it
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
        // We finally display what floor the hero is currently on
        System.out.println("Floor: " + COLOR_WHITE + world.getFloorNumber());
    }

    /**
     * Method for displaying items
     * Currently simply returning items' own
     * toString() methods but should be expanded to
     * a more general display common across all types of items
     * @param item Item to display
     * @return custom display string for the item
     */
    public static String displayItem(Item item){
        return item.toString();
    }

    /**
     * Method for displaying all core statistics
     * related to an instance of a Hero.
     * Currently, it displays name, level, total attributes and equipment-statistics
     * Strength is RED, Dexterity is GREEN and Intelligence is BLUE as is
     * the standard color schemes for such attributes in most rpg games
     * @param hero The hero to be displayed
     * @return custom string for displaying hero
     */
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
