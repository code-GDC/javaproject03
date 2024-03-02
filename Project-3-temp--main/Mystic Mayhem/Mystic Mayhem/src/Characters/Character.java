package Characters;

import Categories.Category;
import Equipment.Equipment;

public class Character {
    private String name;
    private int price;
    private double attack;
    private double defense;
    private double health;
    private double speed;
    private boolean alive;

    private Equipment artefact;
    private Equipment armour;
    private String category;
    

    public Character(String name, int price, double attack, double defense, double health, double speed,String category) {
        this.name = name;
        this.price = price;
        this.attack =attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
        this.alive = true;
        this.category = category;
      
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getAttackValue() {
        return attack;
    }
    public void setAttackValue(double attack) {
        this.attack = attack;
    }

    public double getDefenseValue() {
        return defense;
    }
    public void setDefenseValue(double defense) {
        this.defense = defense;
    }

    public double getHealthValue() {
        return health;
    }

    public void setHealthValue(double health) {
        this.health = health;
    }

    public double getSpeedValue() {
        return speed;
    }
    public void setSpeedValue(double speed) {
        this.speed = speed;
    }


    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public Equipment getArtefact() {
        return artefact;
    }

    public void setArtefact(Equipment artefact) {
        this.artefact = artefact;
    }

    public Equipment getArmour() {
        return armour;
    }

    public void setArmour(Equipment armour) {
        this.armour = armour;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

   
    

    //regular methods
    public void attack(Character target){
        System.out.println(this.getName() + " is attacking "+target.getName());
        double decrement = (0.5 * this.getAttackValue()) - (0.1 * target.getDefenseValue());
        double newHealthValue = target.getHealthValue() - decrement;
        target.setHealthValue(newHealthValue);
    }

    // Methods for calculating modified attributes based on equipment
    public double getModifiedAttack() {
        return attack + (artefact != null ? 0.2 * artefact.getPrice() : 0);
    }

    public double getModifiedDefense() {
        return defense + (armour != null ? 0.2 * armour.getPrice() : 0);
    }

    public double getModifiedHealth() {
        return health;
    }

    public double getModifiedSpeed() {
        return speed;
    }

    // Other methods for customization, battling, etc.

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", baseAttack=" + attack +
                ", baseDefense=" + defense +
                ", baseHealth=" + health +
                ", baseSpeed=" + speed +
                ", artefact=" + artefact +
                ", armour=" + armour +
                '}';
    }
}