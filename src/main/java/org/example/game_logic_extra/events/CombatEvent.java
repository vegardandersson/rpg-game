package org.example.game_logic_extra.events;

import org.example.game_elements.hero.Hero;
import org.example.game_elements_extra.enemy.Enemy;
import org.example.game_elements_extra.actions.IsCombatant;
import org.example.util.services.DisplayService;

import java.util.concurrent.TimeUnit;

/**
 * The type Combat event.
 */
public class CombatEvent implements GameEvent {

    private Enemy enemy;
    private Hero hero;

    /**
     * Instantiates a new Combat event.
     *
     * @param enemy the enemy
     * @param hero  the hero
     */
    public CombatEvent(Enemy enemy, Hero hero){
        this.enemy = enemy;
        this.hero = hero;
    }

    public boolean start(){
        DisplayService.displayMessage("You encountered an enemy of type: " +
                DisplayService.COLOR_WHITE + this.enemy.getEnemyName() +
                DisplayService.COLOR_RESET);
        DisplayService.displayMessage("It engaged combat with you!");

        boolean combatIsOver = false;

        while(!combatIsOver){
            if(conductAttack(this.enemy.getEnemyName(), this.enemy, this.hero.getHeroName(), this.hero)){
                DisplayService.displayMessage("You " + DisplayService.COLOR_RED + "DIED!");
                System.exit(200);
            }
            if(conductAttack(this.hero.getHeroName(), this.hero, this.enemy.getEnemyName(), this.enemy)){
                DisplayService.displayMessage("You killed the " + DisplayService.COLOR_WHITE +
                        this.enemy.getEnemyName() + DisplayService.COLOR_RESET + "!");

                //Replenish HP
                System.out.println("Your " + DisplayService.COLOR_GREEN + "HP" + DisplayService.COLOR_RESET + " replenished!");
                this.hero.getHp().replenishHp();

                //Give Exp
                DisplayService.displayMessage("You gained " +
                        DisplayService.COLOR_YELLOW + this.enemy.getRewardExp().getExp() +
                        DisplayService.COLOR_RESET + " exp!");
                this.hero.getExp().increaseExp(this.enemy.getRewardExp(), this.hero);

                combatIsOver = true;
            }
        }

        return true;
    }

    private boolean conductAttack(String attackerName, IsCombatant attacker, String receiverName, IsCombatant receiver){
        try {
            System.out.println(". . .");
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        float attackDamage = attacker.calculateDamage();
        DisplayService.displayMessage(
                DisplayService.COLOR_WHITE + attackerName +
                DisplayService.COLOR_RESET + " hits " +
                DisplayService.COLOR_WHITE + receiverName +
                DisplayService.COLOR_RESET + " for " +
                DisplayService.COLOR_RED + attackDamage +
                DisplayService.COLOR_RESET + " damage!");
        return receiver.receiveDamage(attackDamage);
    }

}
