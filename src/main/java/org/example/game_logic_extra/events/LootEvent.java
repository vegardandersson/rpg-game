package org.example.game_logic_extra.events;

import org.example.game_elements.equipment.Equipment;
import org.example.game_elements.hero.Hero;
import org.example.game_elements_extra.actions.IsLootable;
import org.example.game_elements_extra.items.Item;
import org.example.util.services.DisplayService;

import java.util.Scanner;

/**
 * The type Loot event.
 */
public class LootEvent implements GameEvent {

    private IsLootable lootable;
    private Hero hero;

    /**
     * Instantiates a new Loot event.
     *
     * @param lootable the lootable
     * @param hero     the hero
     */
    public LootEvent(IsLootable lootable, Hero hero){
        this.lootable = lootable;
        this.hero = hero;
    }

    public boolean start(){
        DisplayService.displayMessage("You opened a " + DisplayService.COLOR_YELLOW + "chest" + DisplayService.COLOR_RESET + "!");
        DisplayService.displayMessage("You found the following item: ");

        Item loot = this.lootable.open();
        DisplayService.displayMessage(DisplayService.displayItem(loot) + "\n");

        DisplayService.displayMessage("Do you want to equip it?");
        DisplayService.displayCommand("Y/N");

        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        while(!validInput) {
            String input = scanner.nextLine().toLowerCase();
            if(!input.matches("[yn]")){
                DisplayService.displayError("Invalid input, try again...");
                continue;
            }
            if(input.equals("y")){
                try {
                    this.hero.equipItem((Equipment) loot);
                    DisplayService.displayMessage(DisplayService.COLOR_GREEN + "Equipped new item!" + DisplayService.COLOR_RESET);
                    DisplayService.displayMessage(DisplayService.displayHero(this.hero));
                }catch (Exception e){
                    DisplayService.displayError(e.getMessage());
                }
            }else{
                DisplayService.displayMessage("You continue exploring the current floor...");
                return false;
            }
            validInput = true;
        }

        return true;
    }
}
