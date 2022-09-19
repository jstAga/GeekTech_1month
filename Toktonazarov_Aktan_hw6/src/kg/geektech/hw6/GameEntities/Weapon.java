package kg.geektech.hw6.GameEntities;

public class Weapon {
    private weaponType weapon;
    private String weaponName;

    public Weapon(weaponType weapon, String weaponName) {
        this.weapon = weapon;
        this.weaponName = weaponName;
    }


    public kg.geektech.hw6.GameEntities.weaponType getWeaponType() {
        return weapon;
    }

    public void setWeaponType(kg.geektech.hw6.GameEntities.weaponType weaponType) {
        this.weapon = weaponType;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
