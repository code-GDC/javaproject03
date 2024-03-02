package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Characters.Character;
import Player.Player;

public class Combat {
    private Player player1; //the player who declared the war
    private Player player2;
    private Player currentPlayer;
    private int result; //0 = draw, 1 = player1 won, 2 = player2 won 

    private List<Character> turnOrder; //maintaining the order of attack of both teams
    private List<Character> targetOrder1;  //maintaining the order of being targeted for player1
    private List<Character> targetOrder2;  //maintaining the order of being targeted for player2

    
    public Combat(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        this.result = 0;
        this.turnOrder = new ArrayList<>();
        this.targetOrder1 = new ArrayList<>();
        this.targetOrder2 = new ArrayList<>();
        initializeTurnOrder();
        initializeTargetOrder();
    }

    private void initializeTurnOrder() {
        // Combine characters from both players into turnOrder and sort them by speed (high to low)
        
        turnOrder.addAll(player1.getArmy().values());
        turnOrder.addAll(player2.getArmy().values());
       
        Collections.sort(turnOrder, Collections.reverseOrder()); // Sort in descending order of speed
    }

    private void initializeTargetOrder() {
        //  sort charcteres by defence low to high
        
        targetOrder1.addAll(player1.getArmy().values());
        targetOrder2.addAll(player2.getArmy().values());
       
        Collections.sort(targetOrder1, Comparator.comparingDouble(Character::getDefenseValue));
        Collections.sort(targetOrder2, Comparator.comparingDouble(Character::getDefenseValue));
    }

    public int getResult(){
        return result;
    }

    public void startCombat() {
        int j = 0,k = 0; //Index numbers for targetOrder2 & targetOrder1
        
        for (int turn = 1; turn <= 20; turn++) {
            System.out.println("Turn " + turn + ": " + getCurrentPlayer(turn).getName());

            // Perform the turn logic (attack, defend, etc.)
            performTurn(turn,j,k);

            // Check for victory conditions
            if (isVictory()) {
                break;
            }

            // Switch the current player for the next turn
            switchCurrentPlayer(turn);
        }

        

    }

    private void performTurn(int i,int j, int k) {
        
        //if i = odd player1's turn
        if(i % 2 == 1){
            turnOrder.get(i).attack(targetOrder2.get(j));

            //Checking whether the enemy character is dead after attacking
            if(targetOrder2.get(j).getHealthValue() <= 0){
                //enemy character is dead. updating index to select the next one in the list as the target.  
                targetOrder2.get(j).setAlive(false);
                j++;
            }
        }else{
            turnOrder.get(i).attack(targetOrder1.get(k));

            //Checking whether the enemy character is dead after attacking
            if(targetOrder1.get(k).getHealthValue() <= 0){
                //enemy character is dead. updating index to select the next one in the list as the target.
                targetOrder1.get(k).setAlive(false);
                k++;
            }

        }
   
    }

    private void switchCurrentPlayer(int turn) {
        if (getCurrentPlayer(turn) == player1) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
    }

    private boolean isVictory() {
        // if there is a winner (all characters of one player are dead)
        boolean allDead1 = true; //related to palyer1's army
        boolean allDead2 = true; //related to palyer2's army
        for (Character character : player1.getArmy().values()) {
            if(character.getAlive()){
                allDead1 = false;
                break;
            }
        }
        for (Character character : player2.getArmy().values()) {
            if(character.getAlive()){
                allDead2 = false;
                break;
            }
        }
        
        if(allDead1){
            result = 2; //player 2 won
        }else if(allDead2){
            result = 1; //player 1 won
        }

        return (allDead1 || allDead2) ? true : false;

    }

    private Player getCurrentPlayer(int turn) {
        // Calculate the current player based on the turn number
        if (turn % 2 == 1) {
            // For odd turns, it's player1's turn
            return player1;
        } else {
            // For even turns, it's player2's turn
            return player2;
        }
    }

    private void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
   

}
