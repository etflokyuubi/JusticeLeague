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
	            else{
	                System.out.println("Please enter correct command.");
	            }
	            System.out.println("Please input your command: ");
	            playerInput = input.nextLine();
	        }
	        System.out.println("Bye " + player1.getPlayerName() + " ~ Thank you for playing our game!");
	 }
}
