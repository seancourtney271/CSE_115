package code;

public class Yoda implements Sentence{


	private String patient;
	private String agent;
	private String verb;

	private Voice voice;

	public Yoda(String s, String v, String o) {
		patient = o;
		agent = s;
		verb = v;
		voice = new NullVoice();
	}
	public void setVoice(Voice v) {
		voice = v;
	}
	
	public String agent() { return agent; }
	public String verb() { return verb; }
	public String patient() { return patient; }
	
	@Override public String toString() {
		return voice.object() + " " + voice.subject() + " " + voice.verb();
	}
}

