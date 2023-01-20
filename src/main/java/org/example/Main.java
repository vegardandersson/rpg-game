package org.example;

import org.example.game_logic_extra.controllers.GameController;

public class Main {
    public static void main(String[] args) {
        GameController gameInstance = new GameController();
        gameInstance.startGame();
    }
}