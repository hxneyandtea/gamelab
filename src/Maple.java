public class Maple extends NPC {
	public Maple() {
			super("maple"); // NOTE: name must be lower-case
	}
@Override
public void talk() {
	say("Woof!");
	String[] responses =
		{
				"Do you happen to know where the notebook is?",
				"Cats or Dogs?",
				"Why are you in my house..?"
		};
	int option = getResponse(responses);
	switch(option) {
	case 1:
		say("Hmmm. I believe it's somewhere in your bedroom. Oh! Or the attic.");
				break;
		case 2:
			say("Well, let's see.I AM a dog, so I would say cats.");
			break;
		case 3:
			say("I should ask why you're in MY house.");
			break;
		default:
			say("Woof!");
		}
	}
}
