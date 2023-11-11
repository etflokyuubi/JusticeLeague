package SCPGame;

public class Consumable extends Item {
	
	// hp recovery value for consumable items
	private int hpValue;

	// constructor from superclass
	public Consumable(int initRoomID, String itemID, String itemName, String itemType, String itemDescription, int hpValue ) {
		super(initRoomID, itemID, itemName, itemType, itemDescription);
		this.hpValue = hpValue;
	}
	
	
	// getters and setters
	public int getHpValue() {
		return hpValue;
	}

}
