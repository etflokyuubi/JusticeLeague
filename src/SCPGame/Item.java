package SCPGame;

public class Item {
	private int initRoomID;
	private String itemID;
	private String itemName;
	private String itemType;
	private String itemDescription;
	
	//Constructor
	public Item(int initRoomID, String itemID, String itemName, String itemType, String itemDescription) {
		super();
		this.initRoomID = initRoomID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
	}

	//Getter
	public int getInitRoomID() { return initRoomID; }

	public String getItemID() { return itemID; }

	public String getItemName() { return itemName; }

	public String getItemType() { return itemType; }

	public String getItemDescription() { return itemDescription; }

	@Override
	public String toString() {
		return "Item [initRoomID=" + initRoomID + ", itemID=" + itemID + ", itemName=" + itemName + ", itemType="
				+ itemType + ", itemDescription=" + itemDescription + "]\n";
	}
	
	
	
}
