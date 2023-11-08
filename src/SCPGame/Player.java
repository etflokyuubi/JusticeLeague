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


}
