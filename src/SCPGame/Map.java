package SCPGame;
import java.io.*;
import java.util.*;


public class Map {
	private static final String defaultFile = "Map.txt";
    ArrayList<Room> myMap = new ArrayList<>();
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Puzzle> puzzleList = new ArrayList<>();
    ArrayList<Monster> monsterList = new ArrayList<>();
    
    public Map() {
        loadRoom();
        System.out.println("Finish loading Room");
        //Uncomment the next line to see all rooms' info
        //System.out.println(myMap);

        loadItem();
//        loadEquipment();
//        loadConsumable();
        for (Item i : itemList) {
            myMap.get(i.getInitRoomID() - 1).addItem(i);
        }
//        System.out.println("Finish adding Item");
        //Uncomment the next line to see all items' info
        //System.out.println(itemList);
//
        loadPuzzle();
        for (Puzzle p : puzzleList) {
            myMap.get(p.getInitRoomID() - 1).setPuzzle(p);
        }
//        System.out.println("Finish adding Puzzle");
        //Uncomment this line to see all puzzles' info
        //System.out.println(puzzleList);
//
        loadMonster();
        for (Monster m : monsterList) {
            myMap.get(m.getInitRoomID() - 1).setMonster(m);
        }
//        System.out.println("Finish adding Monster");
        //Uncomment the next line to see all monsters' info
        //System.out.println(monsterList);
    }

    //Load all rooms
    public void loadRoom(){
        try {
            Scanner scan = new Scanner(new File(defaultFile));
            scan.useDelimiter("~");
            while (scan.hasNext()) {
                int roomID = scan.nextInt();
                String roomName = scan.next();
                String line = scan.nextLine();
                String roomDescription = scan.next();
                line = scan.nextLine();
                int northRoom = scan.nextInt();
                int eastRoom = scan.nextInt();
                int southRoom = scan.nextInt();
                int westRoom = scan.nextInt();
                line = scan.nextLine();
                line = scan.nextLine();
                myMap.add(new Room(roomID,roomName,roomDescription,northRoom,eastRoom,southRoom,westRoom,false));
            }
            scan.close();
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //Loading Item information from Item.txt
    public void loadItem(){
        try {
            Scanner scan = new Scanner(new File("Item.txt"));
            while (scan.hasNext()) {
            	int initRoomID = scan.nextInt();
            	String line = scan.nextLine();
                String itemID = scan.nextLine();
                String itemName = scan.nextLine();
                String itemType = scan.nextLine();
                String itemDescription = scan.nextLine();
                line = scan.nextLine();
                itemList.add(new Item(initRoomID, itemID, itemName, itemType, itemDescription));
            }
            scan.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
//
//    //Loading Equipment information from Equipment.txt
//    public void loadEquipment(){
//        try {
//            Scanner scan = new Scanner(new File("Equipment.txt"));
//            scan.useDelimiter(",");
//            while(scan.hasNext()){
//                int itemID = scan.nextInt();
//                int initRoomID = scan.nextInt();
//                int atkValue = scan.nextInt();
//                String itemName = scan.next();
//                String itemDescription = scan.nextLine();
//                itemDescription = itemDescription.substring(1,itemDescription.length());
//                itemList.add(new Equipment(initRoomID,itemID,itemName,itemDescription,atkValue));
//            }
//            scan.close();
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    //Loading Consumable item information from Consumable.txt
//    public void loadConsumable(){
//        try {
//            Scanner scan = new Scanner(new File("Consumable.txt"));
//            scan.useDelimiter(",");
//            while(scan.hasNext()){
//                int itemID = scan.nextInt();
//                int initRoomID = scan.nextInt();
//                int hpValue = scan.nextInt();
//                String itemName = scan.next();
//                String itemDescription = scan.nextLine();
//                itemDescription = itemDescription.substring(1,itemDescription.length());
//                itemList.add(new Consumable(initRoomID,itemID,itemName,itemDescription,hpValue));
//            }
//            scan.close();
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
    //Loading Puzzle information from Puzzle.txt
    public void loadPuzzle(){
        try {
            Scanner scan = new Scanner(new File("Puzzle.txt"));
            while(scan.hasNext()){
            	int initRoomID = scan.nextInt();
            	String line = scan.nextLine();
                int puzzleID = scan.nextInt();
                line = scan.nextLine();
                String puzzleName = scan.nextLine();
                int numberOfAttempts = scan.nextInt();
                line = scan.nextLine();
                String question = scan.nextLine();
                String answer = scan.nextLine();
                String solvedMessage = scan.nextLine();
                String hint = scan.nextLine();
                int puzzleDmg = scan.nextInt();
                line = scan.nextLine(); line = scan.nextLine();
                puzzleList.add(new Puzzle(initRoomID,puzzleID,puzzleName,numberOfAttempts,question,answer,solvedMessage,hint,puzzleDmg));
            }
            scan.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //Loading Monster information from Monster.txt
    public void loadMonster(){
        try {
            Scanner scan = new Scanner(new File("Monster.txt"));
            scan.useDelimiter("~");
            while(scan.hasNext()){
            	int initRoomID = scan.nextInt();
                String monsterID = scan.next();
                String monsterName = scan.next();
                int monsterHP = Integer.valueOf(scan.next());
                int monsterDmg = Integer.valueOf(scan.next());
                String line = scan.nextLine();
                monsterList.add(new Monster(initRoomID,monsterID,monsterName,monsterHP,monsterDmg));
            }
            scan.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public Room getRoom(int roomID){return myMap.get(roomID-1);} //roomID starts at 1

    public int getNumberOfRooms(){return myMap.size();} //total rooms

    @Override
    public String toString() {
        return "Map{" +
                "MyMap=" + myMap +
                '}';
    }
}
