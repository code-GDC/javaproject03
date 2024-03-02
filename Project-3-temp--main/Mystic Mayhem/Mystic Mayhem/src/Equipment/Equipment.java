package Equipment;
public class Equipment {
    private String name;
    private int price;
    private double attack;
    private double defense;
    private double health;
    private double speed;

    public Equipment(String name, int price, double attack, double defense, double health, double speed) {
        this.name = name;
        this.price = price;
        this.attack =attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }
}
