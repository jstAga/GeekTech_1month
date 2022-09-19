package kg.geektech.hw5;

public abstract class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(1000, 100, "Magical");
        boss.infoOfBoss();

        for (int i = 0; i < createHeroes().length; i++) {
            System.out.println("");
            System.out.println(createHeroes()[i].getAbility());
            System.out.println(createHeroes()[i].getHealth());
            System.out.println(createHeroes()[i].getDamage());
        }
    }

    public static Hero[] createHeroes() {
        Hero[] listOfHero = new Hero[3];
        listOfHero[0] = new Hero(222, 50, "Warrior");
        listOfHero[1] = new Hero(320, 15);
        listOfHero[2] = new Hero();
        return listOfHero;
    }
}