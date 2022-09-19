import java.util.Random;

public class Main {
    public static int bossHealth = 1500;
    public static double bossDamage = 50;
    public static double bossDamageNormal = 50;
    public static String bossDefence;
    public static double[] heroesHealth = {280, 270, 250, 300, 600, 150, 200, 230};
    public static int[] heroesDamage = {10, 15, 20, 0, 5, 10, 5, 15};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Golem", "Lucky", "Berserk", "Thor"};
    public static int roundNumber = 0;


    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            playRound();
        }
    }


    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossHits();
        heroesHit();
        printStatistics();
    }

    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length); // 0,1,2
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {

                if (heroesAttackType[i] == "Golem") {                // GOLEM
                    golemBlock();
                }

                if (heroesAttackType[i] == "Lucky") {
                    luckyRandom(i);
                }

                if (heroesAttackType[i] == "Berserk") {
                    berserkDamage(i);
                }


                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
    }


    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesAttackType[i] == "Medic") {
                    medicHealing();
                }

                if (heroesAttackType[i] == "Thor") {
                    thorBash();
                }


                if (bossDefence == heroesAttackType[i]) {
                    Random random = new Random();
                    int coeff = random.nextInt(9) + 2; // 2,3,4,5,6,7,8,9,10
                    if (bossHealth - heroesDamage[i] * coeff < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i] * coeff;
                    }
                    System.out.println("Critical damage: " + heroesDamage[i] * coeff);
                } else {
                    if (bossHealth - heroesDamage[i] < 0) {
                        bossHealth = 0;
                    } else {
                        bossHealth = bossHealth - heroesDamage[i];
                    }
                }
            }
        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (double healthOfCurrentHero : heroesHealth) {
            if (healthOfCurrentHero > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void printStatistics() {
        if (roundNumber == 0) {
            System.out.println("BEFORE START -------------");
        } else {
            System.out.println("ROUND " + roundNumber + " -------------");
        }
        System.out.println("Boss health: " + bossHealth + "; damage: "
                + bossDamage + "; defence: "
                + (bossDefence == null ? "No defence" : bossDefence));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " +
                    heroesHealth[i] + "; damage: " + heroesDamage[i]);
        }
    }


    public static void medicHealing() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] < 100 && heroesHealth[i] > 0) {
                if (heroesAttackType[i] == "Medic") {
                    System.out.println("SSSS");
                    continue;
                }
                heroesHealth[i] = heroesHealth[i] + 100;
                System.out.println("Medic healed " + heroesAttackType[i]);
                break;
            }
        }
    }

    public static void golemBlock() {
        for (int j = 0; j < heroesHealth.length; j++) {
            if (heroesAttackType[j] == "Golem") {
                heroesHealth[j] = heroesHealth[j] - ((heroesHealth.length - 1) * (bossDamage * 0.2)); // голем принимает урон на себя 1 раз за весь
                continue;                                                                             // отряд в раунде
            } else {
                heroesHealth[j] = heroesHealth[j] + (bossDamage * 0.2);     // всем героям наносится обычный урон от босса,
            }                                                               // но голем восстанавливает 1/5 часть здоровья
        }                                                                   // так реализовал механику блока
    }

    public static void luckyRandom(int i) {
        Random random = new Random();
        boolean dodge = random.nextBoolean();
        if (dodge) {                                                          // если повезет Лаки восстановит себе здоровье от нанесенного
            heroesHealth[i] = heroesHealth[i] + bossDamage;                  // урона от босса
            System.out.println(heroesAttackType[i] + " dodged a hit");
            if (heroesHealth[findIndexOfHero("Golem", heroesAttackType)] > 0) {            // Лаки не лечится от механики блока голема если уворачивается
                heroesHealth[i] = heroesHealth[i] - (bossDamage * 0.2);
            }
        }
    }

    public static void berserkDamage(int i) {
        Random random = new Random();
        int amountBlocked = 50 / (random.nextInt(4) + 2);
        heroesHealth[i] = heroesHealth[i] + amountBlocked;
        bossHealth = bossHealth - amountBlocked;
        System.out.println(heroesAttackType[i] + " extra damage: " + amountBlocked);
    }

    public static void thorBash() {
        Random random = new Random();
        boolean bash = random.nextBoolean();
        if (bash) {
            bossDamage = 0;
            System.out.println("Boss is bashed");
        } else {
            bossDamage = bossDamageNormal; // если оглушение не продливается урон возращается в прежнее состояние
        }
    }

    public static int findIndexOfHero(String heroName, String[] arr) {          // поиск героя по типу атаки
        int index = 0;
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesAttackType[i] == heroName) {
                return index;

            } else {
                index += 1;
            }
        }
        return index;
    }
}

