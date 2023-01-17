package org.example.game_logic;

import org.example.game_elements.Hero;
import org.example.game_elements_extra.WorldGrid;
import org.example.game_elements_extra.types.WorldObjectType;
import org.example.util.DisplayService;

import java.util.Scanner;

public class GameController {

    private Hero hero;
    private WorldGrid world;
    private int[] heroPosition;

    public void startGame(){
        this.setHero(HeroCreationController.createHero());
        System.out.println("Success!\n\n");
        System.out.println(DisplayService.displayHero(this.hero));

        this.world = new WorldGrid(10);
        this.world.generateNewFloor();

        this.heroPosition = new int[]{0, 0};

        this.gameLoop();
    }

    private void gameLoop(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            traverse(scanner);
            WorldObjectType content = this.world.getContentOfPosition(this.heroPosition[0], this.heroPosition[1]);

            if(content == null){
                System.out.println("Moved to (" + this.heroPosition[0] + ", " + this.heroPosition[1] + ")");
            }else {
                switch (content) {
                    case ENEMY -> System.out.println("Enemy encountered!");
                    case CHEST -> System.out.println("Chest encountered!");
                    case EXIT -> System.out.println("You found the exit to the next floor!");
                }
            }
        }
    }

    private void traverse(Scanner scanner) {
        boolean validMove = false;

        while(!validMove){
            System.out.println("W: up, S: down, A: left, D: right");
            String input = scanner.nextLine().toLowerCase();

            int[] newPosition = new int[2];

            switch (input) {
                case "w" -> {
                    newPosition[0] = this.heroPosition[0];
                    newPosition[1] = this.heroPosition[1] + 1;
                }
                case "s" -> {
                    newPosition[0] = this.heroPosition[0];
                    newPosition[1] = this.heroPosition[1] - 1;
                }
                case "d" -> {
                    newPosition[0] = this.heroPosition[0] + 1;
                    newPosition[1] = this.heroPosition[1];
                }
                case "a" -> {
                    newPosition[0] = this.heroPosition[0] - 1;
                    newPosition[1] = this.heroPosition[1];
                }
            }

            if(newPosition[0] >= 0 && newPosition[0] < 10 && newPosition[1] >= 0 && newPosition[1] < 10){
                this.heroPosition = newPosition;
                validMove = true;
            }
        }
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
