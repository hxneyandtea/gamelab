import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {
	
	public static void main(String[] args) {
		TextAdventureGUI.main(args);
	}
	
	public static ArrayList<Item> inventory = new ArrayList<>();
	public static HashMap<String, String> rooms = new HashMap<>();
	public static TextAdventureGUI gui;
	public static Room current;	

	public static void printFile() {
	    try {
	        Scanner fileScan = new Scanner(new File("room.txt"));

	        while (fileScan.hasNextLine()) {
	            String name = fileScan.nextLine().trim();

	            if (name.isEmpty()) {
	                continue; // skip blank lines between entries
	            }

	            String description = "";

	            while (fileScan.hasNextLine()) {
	                String line = fileScan.nextLine();

	                if (line.trim().equals("#")) {
	                    break;
	                }
	                description += line + "\n";
	            }
	            rooms.put(name, description);
	        }
	        fileScan.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static void takeItem(String itemName) {
		Item item = current.getItem(itemName);
		
		if(item == null) {
			Game.print("There is not an item.");
		} else {
			inventory.add(item);
			current.removeItem(itemName);
			Game.print("You have taken the " + item.getItem());
		}
		}

	
	public static void runGameGUI(String command) {
	    command = command.toLowerCase();

	    if (command.isEmpty()) {
	        return;
	    }

	    String[] words = command.split("\\s+");

	    switch (words[0]) {
	        case "east":
	        	move("east");
	        	break;
	        case "west":
	        	move("west");
	        	break;
	        case "north":
	        	move("north");
	        	break;
	        case "south":
	        	move("south");
	        	break;

	        case "take":
	            if (words.length < 2) {
	                print("Take what?");
	            } else {
	                takeItem(words[1]);
	            }
	            break;

	        case "i":
	            if (inventory.isEmpty()) {
	                print("Your inventory is empty.");
	            } else {
	                print("You are carrying: ");
	                for (Item item : inventory) {
	                    print(item);
	                }
	            }
	            break;

	        case "go":
	            if (words.length < 2) {
	                print("Go where?");
	            } else {
	                move(words[1]);
	            }
	            break;

	        case "exit":
	            print("Okay. Farewell.");
	            return;

	        case "save":
	        	saveFile();
	        	print("Game has been saved.");
	        	break;
	        	
	        case "load":
	        	loadFile();
	        	print("Game has been loaded.");
	        	break;
	        	
	        case "use":
	        	if (command.length() == 1) {
	        		print("Use what?");
	        	} else {
	        		useItem(item.getItem());
	        	}
	        	}
	        	break;
	     
	        default:
	            print("Invalid command.");
	            break;
	    }
	}
	    // Display the room after the command
	    print(current.);
	}
	
	public static void print(Object obj) {
	    if (gui != null) {
	        gui.output(String.valueOf(obj));
	    } else {
	        System.out.println(obj);
	    }
	}
	
	public static void move(String d) {
		int dir;
		if (d.equals("east"))
			dir = 0;
		else if(d.equals("west"))
			dir = 1;
		else if(d.equals("north"))
			dir = 2;
		else if(d.equals("south"))
			dir = 3;
		else if(d.equals("up"))
			dir = 4;
		else if(d.equals("down"))
			dir = 5;
	
		else {
			Game.print("You cannot go that way");
			return;
		}

		Room next = current.getExit(dir);
		
		if(next == null)
			Game.print("You cannot go that way");
		else if (next.isLocked())
			Game.print("That way is locked.");
		else {
			current = next;
		}
	}
	
	public static void saveFile() {
		try {
			File saveFile = new File("save0.sav"); 
			saveFile.createNewFile();
	
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
			outStream.writeObject(current);
			outStream.writeObject(World.savedRoom);
			outStream.writeObject(inventory);			
		outStream.close(); 
	    } catch (Exception ex) {
	        ex.printStackTrace();
		}
	}

	public static void loadFile() {
		try {
			File saveFile = new File("save0.sav");
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFile));
			current = (Room) inputStream.readObject();
			World.savedRoom = (ArrayList<Room>) inputStream.readObject();
			inventory = (ArrayList<Item>) inputStream.readObject();	
		inputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

