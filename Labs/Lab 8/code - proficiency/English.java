package code;

/*
 * Creates an English sentence with subject-verb-object word order.
 * 
 */
public class English implements Sentence {

	private String agent;
	private String verb;
	private String patient;
	
	private Voice voice;

	public English(String s, String v, String o) {
		agent = s;
		verb = v;
		patient = o;
		voice = new NullVoice();
	}
	public void setVoice(Voice v) {
		voice = v;
	}
	
	public String agent() { return agent; }
	public String verb() { return verb; }
	public String patient() { return patient; }
	
	@Override public String toString() {
		return voice.subject() + " " + voice.verb() + " " + voice.object();
	}
}
