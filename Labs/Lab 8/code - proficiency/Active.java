package code;

/*
 * Creates an ACTIVE VOICE sentence:
 * maps agent and patient to subject and object roles respective in the sentence.
 */
public class Active implements Voice {
	private Sentence sentence;
	
	public Active(Sentence s) {
		sentence = s;
	}
	
	public String subject() {
		return sentence.agent();
	}

	public String verb() {
		return sentence.verb();
	}
	
	public String object() {
		return sentence.patient();
	}
	
	@Override public String toString() { return "ACTIVE"; }
}
