public class Officekey extends Item {
	private boolean usedOfficekey;
	
	public Officekey() {
			super("officekey"); //calls Item constructor
			 usedOfficekey= false;
	}
@Override
public void use() { //Has to be the same as the method you want to override
	if (Game.current.getName().equals("Living Room")) {
		Room office = Game.rooms.getName("Office");
		if (office.isLocked()) {
			office.setisLocked(false);
			Game.print("You unlock the office using the key you found.");
		} else
			Game.print("You jam the key into every keyhole you find. No dice");			} else {
		
				Game.print("It is already unlocked");
		}
		}
}
