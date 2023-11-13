package SCPGame;

import java.util.*;

public class Game {
	private Scanner input = new Scanner(System.in);
    Player player1;
	public static void main(String[] args) {
		Game game = new Game();
        game.start();
        game.play();
	}
	public void start(){
        System.out.println("Welcome to SCP Imminent Danger! Please type your name:");
        String playerName = input.nextLine();
        Map gameMap = new Map();
        player1 = new Player(playerName,gameMap);
    }
	
	 public void play(){
	        System.out.println("Hello " + player1.getPlayerName() + "! ");
	        player1.enterRoom();
	        System.out.println("Which direction do you want to go? (N/E/S/W) Or type (Exit) to quit the game");
	        String playerInput = input.nextLine();
	        while (!playerInput.equalsIgnoreCase("exit")){
	            if (playerInput.equalsIgnoreCase("n") || playerInput.equalsIgnoreCase("north")){
	                player1.moveNorth();
	                player1.enterRoom();
	            }
	            else if (playerInput.equalsIgnoreCase("e") || playerInput.equalsIgnoreCase("east")){
	                player1.moveEast();
	                player1.enterRoom();
	            }
	            else if (playerInput.equalsIgnoreCase("s") || playerInput.equalsIgnoreCase("south")){
	                player1.moveSouth();
	                player1.enterRoom();
	            }
	            else if (playerInput.equalsIgnoreCase("w") || playerInput.equalsIgnoreCase("west")){
	                player1.moveWest();
	                player1.enterRoom();
	            }
	            else if (playerInput.equalsIgnoreCase("explore")){
	                player1.explore();
	            }
	            else if (playerInput.equalsIgnoreCase("inventory")){
	                player1.showInventory();
	            }
	            else if (playerInput.contains("pickup")){
	            	String itemId = playerInput.substring(7, playerInput.length());
	                player1.pickUp(itemId);
	            }
	            else if (playerInput.contains("drop")){
	            	String itemId = playerInput.substring(5, playerInput.length());
	                player1.dropItem(itemId);
	            }
	            else if (playerInput.contains("inspect")){
	            	String itemId = playerInput.substring(8, playerInput.length());
	                player1.inspectItem(itemId);
	            }
	            else if (playerInput.equalsIgnoreCase("help")){
	                player1.displayHelpMenu();
	            }
	            else if (playerInput.equalsIgnoreCase("location")){
	                player1.displayLocation();
	            }
	            else if (playerInput.equalsIgnoreCase("weapon")){
	                player1.weaponList();
	            }
	            else if (playerInput.equalsIgnoreCase("combine")){
	                player1.combineItem();
	            }
	            else if (playerInput.contains("unequip")){
	            	String itemId = playerInput.substring(8, playerInput.length());
	                player1.unequipItem(itemId);
	            }
	            else if (playerInput.contains("equip")){
	            	String itemId = playerInput.substring(6, playerInput.length());
	                player1.equipItem(itemId);
	            }
	            else if (playerInput.equalsIgnoreCase("stats")){
	                player1.showEquipped();
	            }
	            else if (playerInput.equalsIgnoreCase("heal")) {
	            	player1.useConsumable("");
	            }
	            else if (playerInput.contains("use")) {
	            	String itemId = playerInput.substring(4, playerInput.length());
	            	player1.useItem(itemId);
	            }
	            else if (playerInput.equalsIgnoreCase("ex monster")){
	                player1.inspectMonster();
	            }
	            else if (playerInput.equalsIgnoreCase("info")){
	                player1.showInfo();
	            }
	            else{
	                System.out.println("Please enter correct command.");
	            }
	            if (player1.getPlayerHP() <= 0)
	            	break;
	            System.out.println("Please input your command: ");
	            playerInput = input.nextLine();
	        }
	        System.out.println("Bye " + player1.getPlayerName() + " ~ Thank you for playing our game!");
	 }
}
	 
