package SCPGame;

public class Equippable extends Item{
	
	private int hpValue;

	public Equippable(int initRoomID, String itemID, String itemName, String itemType, String itemDescription,
			int hpValue) {
		super(initRoomID, itemID, itemName, itemType, itemDescription);
		this.hpValue = hpValue;
	}
}
