public class Main {
    public static void main(String[] args) {
        Hero[] heroes = new Hero[3];

        heroes[0] = new Magic(800, 120);
        heroes[1] = new Warrior(1000, 100);
        heroes[2] = new Medic(700, 70);

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Medic)
                ((Medic) heroes[i]).increaseExperience();
            heroes[i].applySuperAbility();

        }
    }

}