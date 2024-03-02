package Characters.Healers;

import Characters.Character;

public class Healer extends Character{

    

    

    public Healer(String name, int price, double attack, double defense, double health, double speed) {
        super(name, price, attack, defense, health, speed);
        //TODO Auto-generated constructor stub
    }

    public void heal(){
        System.out.println("healing");
    }

    //Healer heals his/her army when its his/her turn to attack
    @Override
    public void attack(Character target) {
        heal();
    }


    
}
