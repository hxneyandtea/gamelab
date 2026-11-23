public class Tool extends Item {
	private boolean usedTool;
	
	public Tool() {
			super("tool");
			usedTool = false;
	}
	
@Override
public void useItem() {
	if (Game.current.getName().equals("Bedroom")) {
		if (usedTool) {
			Game.print("The door is already opened.");
		} else {
			Game.current.getExit(4).setisLocked(false);
			usedTool = true;
			Game.print("Using the tool, you are able to open the attic.");
			}
			} else {
			Game.print("You don't see any way to use the tool…");
			}
}
}
