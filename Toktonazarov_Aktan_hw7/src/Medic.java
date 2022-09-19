public class Medic extends Hero{
    int healPoints = 100;
    public Medic(int health, int damage) {
        super(health, damage);
    }

    @Override
    public void applySuperAbility() {
        System.out.println("Medic применил суперспособность Heal");
    }

    public void increaseExperience(){
        healPoints += healPoints * 0.1;
        System.out.println("Medic улучшил способность Heal, теперь она восстанавливает " + healPoints + " здоровья");
    }
}
