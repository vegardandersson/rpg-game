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
        System.out.println("You opened a chest!");
        System.out.println("You found the following item: \n");

        Item loot = this.lootable.open();
        System.out.println(DisplayService.displayItem(loot) + "\n");

        System.out.println("Do you want to equip it?");
        System.out.println("Y/N");

        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        while(!validInput) {
            String input = scanner.nextLine().toLowerCase();
            if(!input.matches("[yn]")){
                System.out.println("Invalid input, try again...");
                continue;
            }
            if(input.equals("y")){
                try {
                    this.hero.equipItem((Equipment) loot);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                System.out.println("Equipped new item!");
                System.out.println(DisplayService.displayHero(this.hero));
            }else{
                System.out.println("You continue exploring the current floor...");
                return false;
            }
            validInput = true;
        }

        return true;
    }
}
