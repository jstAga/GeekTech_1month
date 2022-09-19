package kg.geektech.hw6.general;

import kg.geektech.hw6.GameEntities.*;

public class Main {
    public static void main(String[] args) {
        Weapon bossWeapon = new Weapon(weaponType.SUPER, "Hammer");
        Boss boss = new Boss(100, "Boss", bossWeapon);

//        System.out.println("health: " + boss.getHealth());
//        System.out.println("name: " + boss.getName());
//        System.out.println("weapon " + bossWeapon.getWeaponName());
//        System.out.println("weapon type: " + bossWeapon.getWeaponType());

        Weapon skeletonWeapon1 = new Weapon(weaponType.RANGE, "Super Bow");
        Skeleton skeleton1 = new Skeleton(500, "Bones", skeletonWeapon1, 44);

        Weapon skeletonWeapon2 = new Weapon(weaponType.MELEE, "Super Sword");
        Skeleton skeleton2 = new Skeleton(303, "Skeleton", skeletonWeapon2, 0);

        System.out.println(boss.info());
        System.out.println("");
        System.out.println(skeleton1.info());
        System.out.println("");
        System.out.println(skeleton2.info());
    }
}