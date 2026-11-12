import java.io.Serializable;

public class Item implements Serializable  {
	private String item;
	
	public Item(String i) {
		item = i;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String i) {
		item = i;
	}

	public String toString() {
		return item;
	}

	public String getName() {
		return item;
	}

	public void use() {
		Game.print("You cannot use this item");
		}
}
