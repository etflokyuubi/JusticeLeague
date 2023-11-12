package SCPGame;

import java.util.*;

public class Player {
	private String playerName;
	private Map gameMap;
	private Room currentRoom;
	private Room spawnRoom;
	private int playerHP;
	
	private ArrayList<Item> inventory = new ArrayList<>();
	private ArrayList<Equippable> equipped = new ArrayList<>();
	
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
	
	public ArrayList<Equippable> getEquipped() { return equipped; }

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
            setCurrentRoom(this.spawnRoom);  // Move the player to the spawn room
            displayLocation();  // Display the information about the spawn room
        } else {
            System.out.println("You are not dead. No need to revive.");
        }
    }
    
    //Action happens after player enter a room
    public void enterRoom(){
        displayLocation();
        playPuzzle();
    }
    
    public void inspectMonster() {
        if (currentRoom.getMonster() != null) {
            Monster monster = currentRoom.getMonster();
            System.out.println("You inspect the monster in the room:");
            System.out.println("Monster ID: " + monster.getMonsterID());
            System.out.println("Monster Name: " + monster.getMonsterName());
            System.out.println("Monster HP: " + monster.getMonsterHP());
            System.out.println("Monster Attack: " + monster.getMonsterDmg());
        } else {
            System.out.println("There's no monster to inspect in this room.");
        }
    }


    public void fightMonster() {
        if (currentRoom.getMonster() != null) {
            Monster monster = currentRoom.getMonster();
            System.out.println("You engage in a battle with the monster!");
            
           
            int playerAttack = 0;
            
            // Player attacks the monster
            monster.takeDamage(playerAttack);
            
            // Check if the monster is defeated
            if (monster.isDead()) {
                System.out.println("You have defeated the monster!");
                currentRoom.setMonster(null);  // Remove the defeated monster from the room
            } else {
                // Monster counterattacks
                int monsterAttack = monster.getMonsterDmg();
                setPlayerHP(getPlayerHP() - monster.attack());

                
                // Check if the player is defeated
                if (playerHP <= 0) {
                    System.out.println("You have been defeated by the monster.");
                    revivePlayer();  // Revive the player at the spawn room
                }
            }
        } else {
            System.out.println("There's no monster to fight in this room.");
        }
    }
 
    public void weaponList() {
	 
	    System.out.println("\nYour list of weapons:");
	    System.out.println("--------------------------");

	    boolean foundWeapons = false;

	    for (Item item : inventory) {
	        if (item instanceof Weapon) {
	            Weapon weapon = (Weapon) item;
	            System.out.println("Weapon ID: " + weapon.getItemID());
	            System.out.println("Weapon Name: " + weapon.getItemName());
	            System.out.println("Attack Value: " + weapon.getAtkValue());
	            System.out.println("--------------------------\n");
	            foundWeapons = true;
	        }
	    }

	    if (!foundWeapons) {
	        System.out.println("You don't have any weapons in your inventory.");
	    }
	}
    
    //Print player's current room information including RoomID, RoomName and RoomDescription
    public void displayLocation(){
        System.out.println("\n---------------");
        System.out.println("You are at Room (" + currentRoom.getRoomID() + ") " + currentRoom.getRoomName());
        System.out.println(currentRoom.getRoomDescription());
        System.out.println("---------------\n");
    }
    
    public void displayHelpMenu(){
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
        System.out.printf("| %2s %4s %-10s %6s \n", "location","","Check location","|");
        System.out.printf("| %2s %7s %-10s %6s \n", "stats","","Check HP & ATK","|");
        System.out.printf("| %2s %9s %-10s %7s \n", "map","","Check the map","|");
        System.out.printf("| %2s %8s %-10s %10s \n", "help","","Help menu","|");
        System.out.println("-------------------------------------\n");
    }
    
    //Print items found in the current room
    public void explore() {
    	if (currentRoom.getRoomItems().isEmpty()) {
    		System.out.println("\nNothing but this weird room here.\n");
    	}
    	else {
    		Collections.sort(currentRoom.getRoomItems());
    		System.out.println();
    		for(Item item : currentRoom.getRoomItems()) {
    			System.out.println("----------------------------\n" + item.getItemID() + ": " + item.getItemName());
    		}
    		System.out.println("----------------------------\n");
    	}
    }

    //Show non-equipped items currently in inventory
    public void showInventory() {
    	if(inventory.isEmpty()) {
    		System.out.println("\nYou have nothing in your inventory right now.\n");
    	}
    	else {
    		Collections.sort(inventory);
    		System.out.println();
    		for(Item item : inventory) {
    			System.out.println("----------------------------\n" + item.getItemID() + ": " + item.getItemName());
    		}
    		System.out.println("----------------------------\n");
    	}
    }

    //Pickup an item in a room
    public void pickUp(String itemID) {
    	if(currentRoom.getRoomItems().isEmpty()) {
    		System.out.println("\nThere's nothing here to pick up.");
    	}
    	else {
    		boolean itemfound = false;
    		for(Item item : currentRoom.getRoomItems()) {
    			if(item.getItemID().equals(itemID)) {
    				currentRoom.getRoomItems().remove(item);
    				inventory.add(item);
    				System.out.println();
    				System.out.println("You've pickup up " + item.getItemName() + " and placed it in your inventory.");
    				itemfound = true;
    				break;
    			}
    		}
    		if(!itemfound) {
    			System.out.println("\nThis item does not exist here.");
    		}
			System.out.println();
    	}
    }
    
    //Drop an item from an inventory, put item into the room
    public void dropItem(String itemID) {
    	if(inventory.isEmpty()) {
    		System.out.println("\nThere's nothing to drop.");
    		System.out.println();
    	}
    	else {
    		Item item = findItem(itemID);
    		if(item!=null) {
    				inventory.remove(item);
    				currentRoom.getRoomItems().add(item);
    				System.out.println();
    				System.out.println("You've dropped " + item.getItemName() + " on the floor.");
    		}
    		else {
    			System.out.println("\nYou don't have this item.");
    		}
			System.out.println();
    	}
    }

    public void playPuzzle () {
    	
    	Scanner input = new Scanner(System.in);
    	
    	if (  currentRoom.getPuzzle()!= null) {
    		System.out.println("Hey you have a puzzle to solve!");
    		int numAttempts = currentRoom.getPuzzle().getAttempts();
    		while (numAttempts > 0 ) {
    			System.out.println(currentRoom.getPuzzle().getQuestion());
    			String answer = input.nextLine();
    			if (answer.equalsIgnoreCase(currentRoom.getPuzzle().getAnswer())) {
    				System.out.println("You solved the puzzle!");
    				currentRoom.setPuzzle(null);
    				break;
    			}
    			else if (answer.equalsIgnoreCase("hint")) {
    				System.out.println(currentRoom.getPuzzle().getHint());
    			}
    			else {
    				numAttempts--;
    				
    				System.out.println("You answered incorrectly.");
    				
    			}
    		}
    		    if (numAttempts == 0) {
    			System.out.println("You failed the puzzle. You took damage");
    			this.setPlayerHP(this.getPlayerHP() - currentRoom.getPuzzle().getPuzzleDmg() );
    			System.out.println("Current Health: " + this.getPlayerHP());
    			
    			
    		}
    	}
    }

    //Inspect item
    public void inspectItem(String itemID) {
    	if(inventory.isEmpty()) {
    		System.out.println("\nThere's nothing to inspect.");
    	}
    	else {
    		Item item = findItem(itemID);
    		if(item!=null) {
    				System.out.println("\n" + item.getItemID() + ": " + item.getItemName());
    				System.out.println(item.getItemDescription());
    		}
    		else {
    			System.out.println("\nYou don't have this item.");
    		}
			System.out.println();
    	}
    }
    
    //Find an item in inventory
    public Item findItem(String itemID) {
    	for(Item item : inventory) {
			if(item.getItemID().equals(itemID)) {
				return item;
			}
    	}
    	return null;
    }
    
    public Item findEquip(String itemID) {
    	for(Item item : equipped) {
			if(item.getItemID().equals(itemID)) {
				return item;
			}
    	}
    	return null;
    }
    
    //Remove all key cards in inventory while doing combine
    public void removeAllKeys(String itemID) {
    	for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).getItemID().equals(itemID)) {
				inventory.remove(i);
				--i;
			}
    	}
    }
    
    //Combine 2 keys to get the higher level key
    public void combineItem() {
    	if (currentRoom.getRoomID() != 5) {
    		System.out.println("\nYou can only combine items in Room LC-05.\n");
    		return;
    	}
    	int key0 = 0, key1 = 0, key2 = 0;
    	for (Item item : inventory) {
    		if (item.getItemID().equalsIgnoreCase("A15"))
    			++key0;
    		if (item.getItemID().equalsIgnoreCase("A16"))
    			++key1;
    		if (item.getItemID().equalsIgnoreCase("A17"))
    			++key2;
    	}
    	if (key0 == 2) {
    		Item item = findItem("A15");
    		removeAllKeys("A15");
    		Item combineItem = gameMap.getCombineItem().get(0);
    		inventory.add(combineItem);
    		System.out.println("\nYou have successfully combined 2 " + item.getItemName() + ".");
    		System.out.println(combineItem.getItemID() + ": " + combineItem.getItemName() + " is added to your inventory.\n");
    	}
    	else if (key1 == 2) {
    		Item item = findItem("A16");
    		removeAllKeys("A16");
    		Item combineItem = gameMap.getCombineItem().get(1);
    		inventory.add(combineItem);
    		System.out.println("\nYou have successfully combined 2 " + item.getItemName() + ".");
    		System.out.println(combineItem.getItemID() + ": " + combineItem.getItemName() + " is added to your inventory.\n");
    	}
    	else if (key2 == 2) {
    		Item item = findItem("A17");
    		removeAllKeys("A17");
    		Item combineItem = gameMap.getCombineItem().get(2);
    		inventory.add(combineItem);
    		System.out.println("\nYou have successfully combined 2 " + item.getItemName() +".");
    		System.out.println(combineItem.getItemID() + ": " + combineItem.getItemName() + " is added to your inventory.\n");
    	}
    	else {
    		System.out.println("\nYou don't have any items to combine.\n");
    	}
    }
    
    public void equipItem(String itemID) {
    	// search inventory
    	Item item = findItem(itemID);
    	
    	// if an item is found in the inventory, place it in the equipment array
    	if (inventory.isEmpty()) {
    		System.out.println();
    		System.out.println("You literally have nothing. Pick something up.");
    		System.out.println();
    		
    	} else if(item != null && item instanceof Equippable) {
    		removeFromInventory(itemID);
    		equipped.add((Equippable) item);
    		System.out.println();
    		System.out.println("You've successfully equipped " + item.getItemName() + ".");
    		System.out.println();
    	} else if( !(item instanceof Equippable) ) {
    		System.out.println();
    		System.out.println("This is not an equippable item.\n");
    	} else {
    		System.out.println();
    		System.out.println("This item was not found in your inventory.\n");
    	}
    }
    
    public void unequipItem(String itemID) {
    	// search inventory
    	Item item = findEquip(itemID);
    	
    	// if an item is found in the inventory, place it in the equipment array
    	if (equipped.isEmpty()) {
    		System.out.println();
    		System.out.println("There's nothing on you to remove.");
    		System.out.println();
    		
    	} else if(item != null) {
    		removeFromEquips(itemID);
    		inventory.add((Equippable) item);
    		System.out.println("You've successfully unequipped " + item.getItemName() + ".");
    		System.out.println();
    	} else {
    		System.out.println();
    		System.out.println("You don't have this item on you.");
    		System.out.println();
    	}
    }
    
    public void showEquipped(){
    	if(equipped.isEmpty()) {
    		System.out.println("\nYou have nothing equipped right now.\n");
    	}
    	else {
    		Collections.sort(equipped);
    		System.out.println();
    		System.out.println("Here's what's on you:");
    		for(Equippable equip : equipped) {
    			if(equip.getHpValue() > 0) {
    				System.out.println("----------------------------\n" + equip.getItemID() + ": " + equip.getItemName() + " +" + equip.getHpValue() + " HP.");
    			} else {
    				System.out.println("----------------------------\n" + equip.getItemID() + ": " + equip.getItemName());
    			}
    		}
    		System.out.println("----------------------------\n");
    	}
    }
    
    public void removeFromInventory(String itemID) {
    	for(Item item : inventory) {
    		if(item.getItemID().equalsIgnoreCase(itemID)) {
    			inventory.remove(inventory.indexOf(item));
    			break;
    		}
    	}
    }
    
    public void removeFromEquips(String itemID) {
    	for(Item item : equipped) {
    		if(item.getItemID().equalsIgnoreCase(itemID)) {
    			equipped.remove(equipped.indexOf(item));
    			break;
    		}
    	}
    }


}
    


