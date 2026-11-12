import java.util.ArrayList;

public class World {
	public static ArrayList<Room> savedRoom = new ArrayList<>();

	 public static void main(String[] args) {
		 	Room currentRoom = buildWorld();
		 	System.out.println(currentRoom);
	        
	 }
	public static void print(Object obj) {
		System.out.println(obj);
	    }
	    
	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room");
		Room office = new Room("Office");
	    Room kitchen = new Room("Kitchen");
	    Room bedroom = new Room("Bedroom");
	    Room attic = new Room("Attic");
	    Room garage = new Room("Garage");
	    
	    Item officekey = new Officekey();
	    Item tool = new Tool();
	    Item musicbox = new Item("musicbox");
	    Flashlight flashlight = new Flashlight();
	    Item knife = new Item("knife");
	    Item mysteriousorb = new Item("mysteriousorb");
	    Item couch = new Item("couch");
	    Item bed = new Item("bed");
	    
	    
        livingRoom.addExit(kitchen,0); //
        livingRoom.addExit(office, 1);
        livingRoom.addExit(bedroom, 2);
        livingRoom.addExit(garage, 3);
        
        office.addExit(livingRoom, 0);
        kitchen.addExit(livingRoom, 1);
        bedroom.addExit(livingRoom,  3);
        garage.addExit(livingRoom, 2);

        garage.addExit(bedroom, 0);
        bedroom.addExit(garage, 1);
        
        bedroom.addExit(attic,  4);
        attic.addExit(bedroom,  5);
        
        bedroom.setItem(officekey);
        bedroom.setItem(bed);
        livingRoom.setItem(tool);
        livingRoom.setItem(musicbox);
        livingRoom.setItem(couch);
        kitchen.setItem(knife);
        kitchen.setItem(flashlight);
        kitchen.setItem(mysteriousorb);
        
        office.setisLocked(true);
        attic.setisLocked(true);
        garage.setisLocked(true);
        
	    return livingRoom;
	}
}