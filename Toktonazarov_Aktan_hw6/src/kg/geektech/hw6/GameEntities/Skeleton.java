package kg.geektech.hw6.GameEntities;

public class Skeleton extends Boss{
    private int amountArrows;

    public Skeleton(int health, String name, Weapon weapon, int arrows) {
        super(health, name, weapon);
        this.amountArrows = arrows;
    }

    public int getArrows() {
        return amountArrows;
    }

    public void setArrows(int arrows) {
        this.amountArrows = arrows;
    }

    public String info(){
        return super.info() + " | Amount arrows: " + getArrows();
    }
}
