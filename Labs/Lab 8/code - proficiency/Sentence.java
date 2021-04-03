package code;

public interface Sentence {
	public void setVoice(Voice v);
	public String agent();
	public String verb();
	public String patient();
}

/*
 * Study the class English, which implements Sentence.
 * 
 * Define a similar class named Yoda which creates sentences like Yoda (http://www.imdb.com/character/ch0000015) might speak.
 * 
 * 
 * In the following English sentence Mary is the agent and appears as the subject, while John is the patient and appears as the object.
 * The basic word order is subject-verb-object.
 * 
 *    Mary taught John.
 *    
 * In the following Yoda sentence Mary is the agent and appears as the subject, while John is the patient and appears as the object.
 * The basic word order is object-subject-verb.
 * 
 *    John Mary taught.
 *  
 */
