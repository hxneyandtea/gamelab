public class Bobo extends NPC {
	private int convoNumber;
	
	public Bobo() {
			super("bobo"); // NOTE: name must be lower-case
			convoNumber = 0;
	}
	
	public void talk() {
	say("Hello! How may I help you today?");
	String[] responses =
		{
				"Got any gum?",
				"You can't help me. I'm here to help you.",
				"Can I have 50 cents?"
		};
	int option = getResponse(responses);
	switch(option) {
	case 1:
		say("All we have left is pineapple-flavored gum. Oh" + 
				"wait. Never mind. I'm chewing the last piece.");
			convoNumber = 1;
			break;
		case 2:
			say("Ooh! Nobody's ever helped me before. Thanks!");
			convoNumber = 2;
			break;
		case 3:
			convoNumber = 3;
			say("No.");
			break;
		default:
			say("Uhhh…what?");
		}
	}
}