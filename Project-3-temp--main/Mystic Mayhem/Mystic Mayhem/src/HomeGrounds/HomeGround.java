package HomeGrounds;

import Player.Player;

public abstract class HomeGround {
    private String name;
    private int attackBonus;
    private int defenseBonus;
    private int healthBonus;
    private int speedBonus;
    private double bonusTurnPercentage;

    public HomeGround(String name){
        this.name = name;
    }

    public HomeGround(String name, int attackBonus, int defenseBonus, int healthBonus, int speedBonus, double bonusTurnPercentage) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healthBonus = healthBonus;
        this.speedBonus = speedBonus;
        this.bonusTurnPercentage = bonusTurnPercentage;
    }

    // getters and setters   
    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public int getHealthPenalty() {
        return healthBonus;
    }

    public int getSpeedPenalty() {
        return speedBonus;
    }

    public double getBonusTurnPercentage() {
        return bonusTurnPercentage;
    }

    // other methods
    public abstract void applyHomeGroundEffect(Character character);

    @Override
    public String toString() {
        return "HomeGround{" +
                "name='" + name + '\'' +
                ", attackBonus=" + attackBonus +
                ", defenseBonus=" + defenseBonus +
                ", healthBonus=" + healthBonus +
                ", speedBonus=" + speedBonus +
                ", bonusTurnPercentage=" + bonusTurnPercentage +
                '}';
    }
}