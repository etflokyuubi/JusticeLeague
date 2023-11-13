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
	
<<<<<<< HEAD
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
	            else if (playerInput.contains("pickup") && !playerInput.equalsIgnoreCase("pickup")){
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
	 
=======
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
				
				if(playerInput.length() > 7) {
					String itemId = playerInput.substring(7, playerInput.length());
					player1.pickUp(itemId);
				}
				else
				{
					System.out.println("You did not specify what to pick up.");
					System.out.println();
				}
			}
			else if (playerInput.contains("drop")){
				
				if(playerInput.length() > 5) {
					String itemId = playerInput.substring(5, playerInput.length());
					player1.dropItem(itemId);
				}
				else
				{
					System.out.println("You did not specify what to drop.");
					System.out.println();
				}
			}
			else if (playerInput.contains("inspect")){
				
				if(playerInput.length() > 8) {
					String itemId = playerInput.substring(8, playerInput.length());
					player1.inspectItem(itemId);
				}
				else
				{
					System.out.println("You did not specify what to inspect.");
					System.out.println();
				}
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
				
				if(playerInput.length() > 8) {
					String itemId = playerInput.substring(8, playerInput.length());
					player1.unequipItem(itemId);
				}
				else
				{
					System.out.println("You did not specify what to unequip.");
					System.out.println();
				}
			}
			else if (playerInput.contains("equip")){
				
				if(playerInput.length() > 6) {
					String itemId = playerInput.substring(6, playerInput.length());
					player1.equipItem(itemId);
				}
				else
				{
					System.out.println("You did not specify what to equip.");
					System.out.println();
				}
			}
			else if (playerInput.equalsIgnoreCase("stats")){
				player1.showEquipped();
			}
			else if (playerInput.contains("use")) {
				
				if(playerInput.length() > 4) {
					String itemId = playerInput.substring(4, playerInput.length());
					player1.useItem(itemId);
				}
				else
				{
					System.out.println("You did not specify what to equip.");
					System.out.println();
				}
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

>>>>>>> 324caed29e51b3aa259e24e28e0047a3b37ecc57
