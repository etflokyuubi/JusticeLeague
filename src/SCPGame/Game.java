package SCPGame;

import java.util.*;
import javax.sound.sampled.*;
import java.io.*;

public class Game{
	private Scanner input = new Scanner(System.in);
    Player player1;
	public static void main(String[] args) {
		File file = new File("TheOddMan.wav");
		Game game = new Game();
		// uncomment below for music to work.
		//game.music(file);
        game.start();
        game.play();
	}
	public void start(){
        System.out.println("Welcome to SCP Imminent Danger! Please type your name:");
        String playerName = input.nextLine();
        Map gameMap = new Map();
        player1 = new Player(playerName,gameMap);
    }
	
	public void play() {
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
			else if (playerInput.equalsIgnoreCase("save")){
				File file = new File("Save1.bin");
				try {
					saveGame(player1,file);
					System.out.println("\nYou have sucessfully save the game.\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if (playerInput.equalsIgnoreCase("load")){
				File file = new File("Save1.bin");
				try {
					player1 = loadGame(file);
					player1.setCurrentRoom(player1.getCurrentRoom());
					System.out.println("\nYou have sucessfully load the game.");
					player1.enterRoom();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
	
	// Serialization
    // Save object into a file.
    public static void saveGame(Player obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    // Deserialization
    // Get object from a file.
    public static Player loadGame(File file) throws IOException, ClassNotFoundException {
        Player result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Player) ois.readObject();
        }
        return result;
    }


    public void music(File file) 
    {       
    	
    	try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


