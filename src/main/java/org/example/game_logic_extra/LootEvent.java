package org.example.game_logic_extra;

import org.example.game_elements.Equipment;
import org.example.game_elements.Hero;
import org.example.game_elements_extra.IsLootable;
import org.example.game_elements_extra.Item;
import org.example.util.DisplayService;

import java.util.Scanner;

public class LootEvent implements GameEvent {

    private IsLootable lootable;
    private Hero hero;

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
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                DisplayService.displayMessage(DisplayService.COLOR_GREEN + "Equipped new item!" + DisplayService.COLOR_RESET);
                DisplayService.displayMessage(DisplayService.displayHero(this.hero));
            }else{
                DisplayService.displayMessage("You continue exploring the current floor...");
                return false;
            }
            validInput = true;
        }

        return true;
    }
}
