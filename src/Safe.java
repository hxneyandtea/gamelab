
public class Safe extends Item {
	private boolean isOpen;
	private boolean notebookCreated;
	
	public Safe() {
		super("Safe");
		isOpen = false;
		notebookCreated = false;
	}

	@Override
	public boolean canTake() {
		return false;
	}

	@Override
	public void openItem() {
		if (isOpen) {
			Game.print("The safe has already been opened.");
		} else {
			isOpen = true;
			if(!notebookCreated) {
				notebookCreated = true;
				Game.current.setItem(new Notebook());
				Game.print("You open the safe and you find the notebook, along with a few dead mice.");
			} else {
				Game.print("You open the safe again.");
			}
		}
	
	}
	
	@Override
	public void closeItem() {
		if(!isOpen) {
			Game.print("The safe is already closed.");
		} else {
			isOpen = false;
			Game.print("You close the safe.");
		}
	}
}
