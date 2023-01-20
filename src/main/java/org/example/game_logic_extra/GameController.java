package org.example.game_logic_extra;

import org.example.game_elements.Hero;
import org.example.game_elements_extra.Chest;
import org.example.game_elements_extra.Goblin;
import org.example.game_elements_extra.WorldGrid;
import org.example.game_elements_extra.types.WorldObjectType;
import org.example.util.DisplayService;

import java.util.Scanner;

/**
 * The type Game controller.
 */
public class GameController {

    private Hero hero;
    private WorldGrid world;
    private int[] heroPosition;

    /**
     * Start game.
     */
    public void startGame(){
        this.setHero(HeroCreationController.createHero());
        DisplayService.displayMessage(DisplayService.displayHero(this.hero));

        this.world = new WorldGrid(10);
        this.world.generateNewFloor();

        this.heroPosition = new int[]{0, 0};

        this.gameLoop();
    }

    private void gameLoop(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            DisplayService.displayWorld(this.world, this.heroPosition);
            traverse(scanner);
            WorldObjectType content = this.world.getContentOfPosition(this.heroPosition[0], this.heroPosition[1]);

            if(content != null){
                switch (content) {
                    case ENEMY -> {
                        GameEvent event = new CombatEvent(new Goblin(), this.hero);
                        event.start();
                        DisplayService.displayMessage("Encounter over...");
                        this.world.setIndividualWorldGridTile(null, this.heroPosition);
                    }
                    case CHEST -> {
                        GameEvent event = new LootEvent(new Chest(), this.hero);
                        if(event.start()) {
                            DisplayService.displayMessage("Encounter over...");
                            this.world.setIndividualWorldGridTile(null, this.heroPosition);
                        }
                    }
                    case EXIT -> {
                        DisplayService.displayMessage("You found the " +
                                DisplayService.COLOR_BLUE + "exit" +
                                DisplayService.COLOR_RESET + " to the next floor!");
                        DisplayService.displayMessage("Do you wish to continue to the next floor?");
                        DisplayService.displayCommand("Y/N");
                        boolean validInput = false;
                        while(!validInput) {
                            String input = scanner.nextLine().toLowerCase();
                            if(!input.matches("[yn]")){
                                DisplayService.displayError("Invalid input, try again...");
                                continue;
                            }
                            if(input.equals("y")){
                                this.world.generateNewFloor();
                                this.heroPosition = new int[]{0, 0};
                            }else{
                                DisplayService.displayMessage("You continue exploring the current floor...");
                            }
                            validInput = true;
                        }
                    }
                }
            }
        }
    }

    private void traverse(Scanner scanner) {
        boolean validMove = false;

        while(!validMove){
            DisplayService.displayCommand("W: up, S: down, A: left, D: right (H: Display Hero)");
            String input = scanner.nextLine().toLowerCase();

            if(!input.matches("[wasd]")){
                DisplayService.displayError("Invalid input, try again...");
                continue;
            }

            int[] newPosition = new int[2];
            switch (input) {
                case "d" -> {
                    newPosition[0] = this.heroPosition[0];
                    newPosition[1] = this.heroPosition[1] + 1;
                }
                case "a" -> {
                    newPosition[0] = this.heroPosition[0];
                    newPosition[1] = this.heroPosition[1] - 1;
                }
                case "s" -> {
                    newPosition[0] = this.heroPosition[0] + 1;
                    newPosition[1] = this.heroPosition[1];
                }
                case "w" -> {
                    newPosition[0] = this.heroPosition[0] - 1;
                    newPosition[1] = this.heroPosition[1];
                }
                case "h" -> {
                    DisplayService.displayMessage(DisplayService.displayHero(this.hero));
                    validMove = true;
                    continue;
                }
            }

            if(newPosition[0] >= 0 && newPosition[0] < 10 && newPosition[1] >= 0 && newPosition[1] < 10){
                this.heroPosition = newPosition;
                validMove = true;
            }else{
                DisplayService.displayError("You hit the wall, turn back!");
            }
        }
    }

    /**
     * Sets hero.
     *
     * @param hero the hero
     */
    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
