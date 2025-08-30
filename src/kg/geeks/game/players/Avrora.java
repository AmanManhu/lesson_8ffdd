package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Avrora extends Hero {


    public Avrora(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.INVISIBILITY);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() < 2){
            this.setHealth(this.getHealth() + boss.getDamage());
            boss.setHealth(boss.getHealth() - boss.getDamage());
            System.out.println("Aurora was invisible");
        }
    }
}