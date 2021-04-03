package code;

public class Tester {
	public static void main(String[] args) {
		Sentence s1 = new English("Mary","taught","John");
		s1.setVoice(new Active(s1));
		System.out.println(s1);
		Sentence s2 = new English("John","Mary","taught");
		s2.setVoice(new Active(s2));
		System.out.println(s2);
		s1.setVoice(new Passive(s1));
		System.out.println(s1);
	}
}
