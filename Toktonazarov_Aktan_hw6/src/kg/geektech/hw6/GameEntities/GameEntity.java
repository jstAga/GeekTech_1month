package kg.geektech.hw6.GameEntities;

public class GameEntity {
    private int health;
    private String name;

    public GameEntity() {
    }
    public GameEntity(int health, String name) {
        this.health = health;
        this.name = name;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String info(){
        return "Health: " + this.health + " | Name: " + this.name;
    }


}
