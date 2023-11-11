package SCPGame;

import java.util.Random;

public class Monster {
	private int initRoomID;
	private String monsterID;
	private String monsterName;
	private int monsterHP;
	private int monsterDmg;
	private int damageThreshold; // Threshold for double damage
	private boolean isDead;
	
	public Monster(int initRoomID, String monsterID, String monsterName, int monsterHP, int monsterDmg,int damageThreshold) {
		super();
		this.initRoomID = initRoomID;
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.monsterHP = monsterHP;
		this.monsterDmg = monsterDmg;
		this.damageThreshold = damageThreshold;
		this.isDead = false; // Initialize as not dead
		
	}
	
	public int attack() {
        int randNumber = new Random().nextInt(100);
        if (randNumber < damageThreshold) {
            return monsterDmg * 2; // Double damage if random number is below the threshold
        }
        return monsterDmg;
    }

    public void takeDamage(int damage) {
        this.monsterHP -= damage;
        if (this.monsterHP <= 0) {
            this.monsterHP = 0;
            this.isDead = true; // Set the monster as dead when HP reaches 0
        }
    }
	
	//Getter
    public boolean isDead() {
        return isDead;
    }
    
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
