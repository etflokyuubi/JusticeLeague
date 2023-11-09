package SCPGame;

public class Monster {
	private int initRoomID;
	private String monsterID;
	private String monsterName;
	private int monsterHP;
	private int monsterDmg;
	public Monster(int initRoomID, String monsterID, String monsterName, int monsterHP, int monsterDmg) {
		super();
		this.initRoomID = initRoomID;
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.monsterHP = monsterHP;
		this.monsterDmg = monsterDmg;
	}
	
	//Getter
	public int getInitRoomID() { return initRoomID; }
	
	public String getMonsterID() { return monsterID; }
	
	public String getMonsterName() { return monsterName; }
	
	public int getMonsterHP() { return monsterHP; }

	public int getMonsterDmg() { return monsterDmg; }

	//Setter
	public void setInitRoomID(int initRoomID) { this.initRoomID = initRoomID; }

	public void setMonsterID(String monsterID) { this.monsterID = monsterID; }

	public void setMonsterName(String monsterName) { this.monsterName = monsterName; }

	public void setMonsterHP(int monsterHP) { this.monsterHP = monsterHP; }

	public void setMonsterDmg(int monsterDmg) { this.monsterDmg = monsterDmg; }

	@Override
	public String toString() {
		return "Monster [initRoomID=" + initRoomID + ", monsterID=" + monsterID + ", monsterName=" + monsterName
				+ ", monsterHP=" + monsterHP + ", monsterDmg=" + monsterDmg + "]\n";
	}
	
}
