package kg.geektech.hw5;

public class Boss {
    private int health;
    private int damage;
    private String defence;

    Boss() {
    }

    public Boss(int health, int damage, String defence) {
        this.health = health;
        this.damage = damage;
        this.defence = defence;
    }

    public void infoOfBoss() {
        System.out.println("Boss information:");
        System.out.println("Health: " + getHealth());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defence: " + getDefence());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (this.health > 0) {
            this.health = health;
        } else {
            System.out.println("Wrong");
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDefence() {
        return defence;
    }

    public void setDefence(String defence) {
        this.defence = defence;
    }
}
