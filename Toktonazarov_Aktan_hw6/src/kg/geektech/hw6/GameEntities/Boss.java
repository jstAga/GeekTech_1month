package kg.geektech.hw6.GameEntities;

public class Boss extends GameEntity {
    Weapon weapon;

    public Boss(int health, String name, Weapon weapon) {
        super();
        this.setHealth(health);
        this.setName(name);
        this.weapon = weapon;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String info() {
        return super.info() + " | Weapon: " + this.weapon.getWeaponName() + " | Weapon Type: " + this.weapon.getWeaponType();
    }
}
