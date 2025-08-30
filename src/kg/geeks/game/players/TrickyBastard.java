package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Random;

public class TrickyBastard extends Hero{
    private boolean chance = new Random().nextBoolean();

    public TrickyBastard(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.MASKING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!RPG_Game.useAbilityMasking && chance && this.getHealth()>0){
            this.setHealth(this.getHealth() + boss.getDamage());
            boss.setHealth(boss.getHealth() + this.getDamage());
            RPG_Game.useAbilityMasking = true;
            chance = false;
            System.out.println("TrickyBastard masking");
        }
    }
}
