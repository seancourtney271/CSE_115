package code;

public interface Voice {
	public String subject();
	public String verb();
	public String object();	
}

/*
 * Study the class Active, which implements Voice.
 * Define a similar class named Passive which creates a PASSIVE VOICE sentence:
 * maps agent and patient to object and subject roles respective in the sentence, and inserts "was" and "by" correctly:
 * 
 * In the following active sentence Mary is the agent and appears as the subject, while John is the patient and appears as the object:
 * 
 *    Mary taught John.
 *    
 * In the following passive sentence Mary is the agent and appears as the object, while John is the patient and appears as the subject:
 * 
 *    John was taught by Mary.
 *  
 */
