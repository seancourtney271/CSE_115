package code;

public class Passive implements Voice{
private Sentence sentence;
	
	public Passive(Sentence s) {
		sentence = s;
	}
	
	public String subject() {
		return sentence.patient() +" was";
	}

	public String verb() {
		return sentence.verb();
	}
	
	public String object() {
		return   "by " + sentence.agent();
	}
	
	@Override public String toString() { return "PASSIVE"; }
}
