package SCPGame;

public class Weapon extends Item{
	private int atkValue;
	
	//Constructor from superclass
	public Weapon(int initRoomID, String itemID, String itemName, String itemType, String itemDescription,
			int atkValue) {
		super(initRoomID, itemID, itemName, itemType, itemDescription);
		this.atkValue = atkValue;
	}

	//Getters
	public int getAtkValue() { return atkValue; }

}
