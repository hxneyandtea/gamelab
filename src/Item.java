import java.io.Serializable;

public class Item implements Serializable  {
	protected String item;
	
	public Item(String i) {
		this.item = i;
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

	public boolean canTake() {
		return true;
	}
	
	public void useItem() {
		Game.print("You cannot use this item");
		}
	
	public void openItem() {
		Game.print("You cannot open the" + item);
	}
	
	public void closeItem() {
		Game.print("You cannot close the" + item);
	}
	
	public void readItem() {
		Game.print("You cannot read the " + item);
	}


}
