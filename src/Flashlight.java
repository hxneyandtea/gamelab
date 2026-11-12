public class Flashlight {

	private boolean foundKey;
	
	public Flashlight() {
		super("flashlight");
		foundKey = false;
		
	}
	@Override
	public void use() {
		if(Game.current.getName().equals("Bedroom")) {
			if(foundKey)
				Game.print("You search and search but find nothing else useful");
			else {
			Game.print("You turn on the flashlight and start searching for"
					+ "clues and hidden treasure. Instead, you find the office"
					+ "key hidden under the bed.");
			Game.current.setItem(new OfficeKey());
			foundKey = true;
			}
	} else
		Game.print("You turn the flashlight on and off for shits and giggles.");

}
