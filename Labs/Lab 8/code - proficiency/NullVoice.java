package code;

public class NullVoice implements Voice {

	@Override
	public String subject() {
		return "";
	}

	@Override
	public String verb() {
		return "";
	}

	@Override
	public String object() {
		return "";
	}

	@Override public String toString() { return "(null)"; }
}
