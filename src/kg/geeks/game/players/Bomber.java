package kg.geeks.game.players;


import kg.geeks.game.logic.RPG_Game;

public class Bomber extends Hero{

    public Bomber(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOM);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if(!RPG_Game.useAbilityBomber && this.getHealth() == 0){
            boss.setHealth(boss.getHealth() - 100);
            System.out.println("Bomber exploded");
        }
    }
}
