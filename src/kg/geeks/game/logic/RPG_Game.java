package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int roundNumber;
    public static boolean useAbilityBomber = false;
    public static boolean useAbilityMasking = false;


    public static void startGame() {
        Boss boss = new Boss("Goblin", 2000, 100);
        Warrior warrior1 = new Warrior(
                "Heracles", 280, 15);
        Warrior warrior2 = new Warrior(
                "Achilles", 270, 20);
        Magic magic = new Magic("Vedmak", 290, 10,15);
        Berserk berserk = new Berserk("Guts", 260, 10);
        Medic doc = new Medic("Lekar", 250, 5, 15);
        Medic assistant = new Medic("Chilchak", 300, 5, 5);
        Avrora aurora = new Avrora("Auroro", 250, 20);
        Bomber bomber = new Bomber("Bomber", 100, 20);
        TrickyBastard trickyBastard = new TrickyBastard("Tricky", 250, 25);

        Hero[] heroes = {warrior1, doc, magic, warrior2, berserk, assistant, aurora, bomber, trickyBastard};

        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
                useAbilityBomber = true;
            }
        }
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ------------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }

    public static void setRoundNumber(int roundNumber) {
        RPG_Game.roundNumber = roundNumber;
    }
}
