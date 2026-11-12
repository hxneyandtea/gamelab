import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Room implements Serializable {
	private String name;
	private Room[] r;
	private HashMap<String, Item> item;
	private static HashMap<String, Room> rooms;
	private boolean isLocked = false;
	
	
	public Room(String n) {
		name = n;
		r = new Room[6];
		item = new HashMap<>();
		World.savedRoom.add(this);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return Game.rooms.get(name);	
	}
	
	public void setName(String n) {
		name = n;
	}

	public void setDescription(HashMap<String, String> d) {
		Game.rooms = d;
	}
	public String toString() {
		return name+"\n" + Game.rooms.get(name);
		}
	
	public void addExit(Room w, int x) {
		r[x] = w;
	}
	
	public Room getExit(int y) {
		return r[y];
	}
	
	public void addItem(String n, Item i) {
		item.put(n, i);
	}
	
	public Item getItem(String n) {
		return item.get(n);
	}

	public void setItem(Item i) {
		item.put(i.getName(), i);
	}

	public void removeItem(String n) {
		item.remove(n);
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setisLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	
	
}	