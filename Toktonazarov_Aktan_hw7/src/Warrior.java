public class Warrior extends Hero{

    public Warrior(int health, int damage) {
        super(health, damage);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Warrior применил суперспособность Critical Damage");
    }
}
