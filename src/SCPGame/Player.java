package SCPGame;

import java.util.*;

public class Player {
	private String playerName;
	private Map gameMap;
	private Room currentRoom;
	private Room spawnRoom;
	private int playerHP;
	
	private ArrayList<Item> inventory = new ArrayList<>();
	private ArrayList<Item> equipped = new ArrayList<>();
	
	//Constructor
	public Player(String playerName, Map gameMap) {
		super();
		 this.playerName = playerName;
	     this.gameMap = gameMap;
	     this.currentRoom = gameMap.getRoom(1);
	     this.spawnRoom = currentRoom;
	     currentRoom.setVisited(true);
	     this.playerHP = 100;
	}
	
	//Getter
    public String getPlayerName() { return playerName; }

	public Room getCurrentRoom() { return currentRoom; }

	public Room getSpawnRoom() { return spawnRoom; }
	
	public int getPlayerHP() { return playerHP; }
	
	public ArrayList<Item> getInventory() { return inventory; }
	
	public ArrayList<Item> getEquipped() { return equipped; }

	//Setter
	public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

	public void setSpawnRoom(Room spawnRoom) { this.spawnRoom = spawnRoom; }

	public void setPlayerHP(int playerHP) { this.playerHP = playerHP; }
	

	//Check if a room is Visited
	public void checkVisited(){
        if (currentRoom.isVisited())
            System.out.println("This Region looks familiar.");
        else currentRoom.setVisited(true);
    }

	//Move player to North Room
    public void moveNorth(){
        if (currentRoom.getNorthRoom() == 0)
            System.out.println("You cannot go this way. Please choose another direction!");
        else {
            setCurrentRoom(gameMap.getRoom(currentRoom.getNorthRoom()));
            checkVisited();
        }
    }

    //Move player to East Room
    public void moveEast(){
        if (currentRoom.getEastRoom() == 0)
            System.out.println("You cannot go this way. Please choose another direction!");
        else {
            setCurrentRoom(gameMap.getRoom(currentRoom.getEastRoom()));
            checkVisited();
        }
    }

    //Move player to South Room
    public void moveSouth(){
        if (currentRoom.getSouthRoom() == 0)
            System.out.println("You cannot go this way. Please choose another direction!");
        else {
            setCurrentRoom(gameMap.getRoom(currentRoom.getSouthRoom()));
            checkVisited();
        }
    }

    //Move player to West Room
    public void moveWest(){
        if (currentRoom.getWestRoom() == 0)
            System.out.println("You cannot go this way. Please choose another direction!");
        else {
            setCurrentRoom(gameMap.getRoom(currentRoom.getWestRoom()));
            checkVisited();
        }
    }
    //Revive player to Spawn Room
    public void revivePlayer() {
        if (playerHP <= 0) {
            System.out.println("You have been revived at the spawn room.");
            setPlayerHP(100);  // Reset player's HP to the maximum value
            setCurrentRoom(getSpawnRoom());  // Move the player to the spawn room
            displayLocation();  // Display the information about the spawn room
        } else {
            System.out.println("You are not dead. No need to revive.");
        }
    }
    
    //Action happens after player enter a room
    public void enterRoom(){
        displayLocation();
    }
    
    //Print player's current room information including RoomID, RoomName and RoomDescription
    public void displayLocation(){
        System.out.println("\n---------------");
        System.out.println("You are at Room (" + currentRoom.getRoomID() + ") " + currentRoom.getRoomName());
        System.out.println(currentRoom.getRoomDescription());
        System.out.println("---------------\n");
    }
    
    public void displayCommand(){
        System.out.println("\n--------------HELP MENU--------------");
        System.out.printf("| %2s %5s %-10s %10s \n", "n/north", "", "Move North","|");
        System.out.printf("| %2s %6s %-10s %10s \n", "e/east","","Move East","|");
        System.out.printf("| %2s %5s %-13s %7s \n", "s/south","", "Move South","|");
        System.out.printf("| %2s %6s %-13s %7s \n", "w/west","","Move West","|");
        System.out.printf("| %2s %5s %-13s %6s \n", "explore","","Explore a room","|");
        System.out.printf("| %2s %3s %-10s %5s \n", "inventory","", "Check inventory","|");
        System.out.printf("| %2s %6s %-10s %8s \n", "pickup","","Pick up item","|");
        System.out.printf("| %2s %8s %-10s %10s \n", "drop","","Drop item","|");
        System.out.printf("| %2s %5s %-13s %7s \n", "inspect","","Inspect item","|");
        System.out.printf("| %2s %7s %-13s %7s \n", "equip","","Equip item","|");
        System.out.printf("| %2s %5s %-13s %7s \n", "unequip","","Unequip item","|");
        System.out.printf("| %2s %9s %-10s %10s \n", "use","","Use item","|");
        System.out.printf("| %2s %6s %-10s %5s \n", "attack","","Fight a monster","|");
        System.out.printf("| %2s %6s %-10s %4s \n", "ignore","","Ignore a monster","|");
        System.out.printf("| %2s %4s %-10s %6s \n", "location","","Check location","|");
        System.out.printf("| %2s %7s %-10s %6s \n", "stats","","Check HP & ATK","|");
        System.out.printf("| %2s %9s %-10s %7s \n", "map","","Check the map","|");
        System.out.printf("| %2s %8s %-10s %10s \n", "help","","Help menu","|");
        System.out.println("-------------------------------------\n");
    }


    public void explore() {
    	
    }

}
