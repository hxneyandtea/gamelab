import javax.swing.JOptionPane;

public class NPC {
	private String name;
	
	public NPC(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void say(String dialog) {
		Game.print(name.toUpperCase());
		Game.print(dialog);
	}

	public void talk() {
		Game.print("You cannot talk to " + name + ".");
	}

	public int getResponse(String[] responses) {
		for(int i = 0; i < responses.length; i++) {
			Game.print((i +1) + ") " + responses[i]);
		}
	String input = JOptionPane.showInputDialog(null, "Choose an option: ");
	if (input == null) {
		return 0;
	}
	
	input = input.trim();
	for (int i = 1; i <= responses.length; i++) {
		if(input.equals("" + i)) {
			return i;
		}
	}
	return 0;
	}
}
