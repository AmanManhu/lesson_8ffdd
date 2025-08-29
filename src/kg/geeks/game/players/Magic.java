package kg.geeks.game.players;

public class Magic extends Hero {
    private int round = 0;
    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        // TODO Here will be implementation of boosting


    }
    public void SuperPower(Boss boss, Hero[] heroes) {
        round++;
        if (round <= 4){
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && hero != this){
                    hero.setDamage(hero.getDamage() + 10);
                }
            }
        }
    }
}
