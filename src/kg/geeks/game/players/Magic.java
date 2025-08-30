package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    private int boost;

    public Magic(String name, int health, int damage, int boost) {
        super(name, health, damage, SuperAbility.BOOST);
        this.boost = boost;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() < 4 && this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setDamage(heroes[i].getDamage() + boost);
            }
            System.out.println("Magic increased damage");
        }

    }
}
