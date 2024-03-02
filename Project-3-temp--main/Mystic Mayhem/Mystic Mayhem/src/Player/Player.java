package Player;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Characters.Character;
import HomeGrounds.HomeGround;

public class Player {
    private static int userIDCount = 1;
    
    private String name;
    private String username;
    private int userID;
    private int XP;
    private int goldCoins;
    private String homeGround;
    private Map<String, Character> army;

    // Collection to store existing usernames
    private static Set<String> existingUsernames = new HashSet<>();

    public Player(String name, String username) {
        this.userID = userIDCount++;
        this.name = name;

        // Check if the username is available before assigning it
        if (checkAvailabilityOfUsername(username)) {
            this.username = username;
            existingUsernames.add(username);
        } else {
            throw new IllegalArgumentException("Username is already taken. Please choose a different username.");
        }

       
        this.XP = 0;
        this.goldCoins = 500;
        this.homeGround = null;  // Default home ground is set to null
        this.army = new HashMap<>();
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return userID;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP){
        this.XP = XP;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins){
        this.goldCoins = goldCoins;
    }
    
    public Map<String, Character> getArmy() {
        return army;
    }

    
    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    public String getHomeGround() {
        return homeGround;
    }

    // regular methods 

    // Methods related to Gold Coins
    public void increaseGoldCoins(int amount) {
        goldCoins += amount;
    }

    public void decreaseGoldCoins(int amount) {
        if (amount <= goldCoins) {
            goldCoins -= amount;
        } else {
            System.out.println("Insufficient gold coins!");
        }
    }

    

    // Methods related to Army
    public void addToArmy(String category, Character character) {
        if (!army.containsKey(category)) {
            army.put(category, character);
        }
    }

    public void removeFromArmy(String category) {
        army.remove(category);
    }

    //Methods related to Login
    public void login(){
        //todo
    }

    
    public static boolean checkAvailabilityOfUsername(String newUsername) {
        return !existingUsernames.contains(newUsername);
    }
    //Methods related to Gameplay 

    public void searchForOpponents(){
        System.out.println("searching opponents");
        System.out.println("display name & XP of other players.One at a time");
    };
    
    public void acceptChallenge(){
        System.out.println("Challenge accepted");
    }

    public void skipToNextPlayer(){
        System.out.println("skipping to the next palyer");
    }

    public void selectHomeGround(){
        System.out.println("Home ground has been selected");
    }

     

    // Other methods for battling, buying characters, equipment, etc.

    @Override
    public String toString() {
        return "Player{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", XP=" + XP +
                ", goldCoins=" + goldCoins +
                ", homeGround='" + homeGround + '\'' +
                ", army=" + army +
                '}';
    }
}
