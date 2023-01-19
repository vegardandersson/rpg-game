package org.example.game_logic_extra;

import org.example.game_elements.Hero;
import org.example.game_elements_extra.Enemy;
import org.example.game_elements_extra.IsCombatant;
import org.example.util.DisplayService;

public class CombatEvent implements GameEvent {

    private Enemy enemy;
    private Hero hero;

    public CombatEvent(Enemy enemy, Hero hero){
        this.enemy = enemy;
        this.hero = hero;
    }

    public boolean start(){
        System.out.println("You encountered an enemy of type: " + this.enemy.getEnemyName());
        System.out.println("It engaged combat with you!");

        boolean combatIsOver = false;

        while(!combatIsOver){
            if(conductAttack(this.enemy, this.hero)){
                System.out.println("You died!");
                System.exit(200);
            }
            if(conductAttack(this.hero, this.enemy)){
                System.out.println("You killed the " + this.enemy.getEnemyName() + "!\n");

                //Replenish HP
                System.out.println("Your HP replenished!\n");
                this.hero.getHp().replenishHp();

                //Give Exp
                System.out.println("You gained " +
                        DisplayService.COLOR_YELLOW + this.enemy.getRewardExp().getExp() +
                        DisplayService.COLOR_RESET + " exp!");
                this.hero.getExp().increaseExp(this.enemy.getRewardExp(), this.hero);

                combatIsOver = true;
            }
        }

        return true;
    }

    private boolean conductAttack(IsCombatant attacker, IsCombatant receiver){
        return receiver.receiveDamage(attacker.calculateDamage());
    }

}
