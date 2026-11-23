
public class Notebook extends Item {
	private boolean readNotebook;
	
	public Notebook() {
		super("Notebook");
		readNotebook = false;
	
	}
	@Override
	public void readItem() {
		if(!Game.inventory.contains("notebook")) {
				Game.print("You cannot read anything. You must pick up the notebook first.");;
		} else {
			if (!readNotebook) {
				readNotebook = true;
				Game.print("You flip through the boring pages. You come across a loose piece of paper"
						+ "and find the password: ABCD");
				Game.inventory.add(new Item("password"));
			} else {
				Game.print("You reread the notebook and password. Go use it!");
				
			}
		}
	}
}

