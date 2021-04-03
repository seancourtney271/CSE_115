package code;

public class Demo {

	/*
	 * Agenda
	 * 
	 *    String methods
	 *    	length() -> int
	 *    	charAt(int) -> char
	 *      equals(String) -> boolean
	 *      compareTo(String) -> int
	 *      concatenation (+)
	 *      
	 *    loops
	 *      for loop with String, ArrayList
	 *      filtering ArrayList -> ArrayList
	 *    
	 */
	
	public void begin() {
		String name = "River";
	//	System.out.println( name.length() );  // similar to size() for ArrayList
//		for (int i=0; i<name.length(); i=i+1) {
//			System.out.println( name.charAt(i) ); // similar to get(int) for ArrayList
//		}
		System.out.println( codesForProtein("CGATGTAGCTCAGATCGCTAGACTTGATCG") ); // true
		System.out.println( codesForProtein("CGCTGTAGCTCAGATCGCTAGACTTGATCG") ); // false
		System.out.println( codesForProtein("ATGA") ); // false
		System.out.println( codesForProtein("TGACCCATGCCCTGA") ); // false
	}
	
	
	/*
	 * Genes that code for proteins comprise open reading 
	 * frames (ORFs) consisting of a series of codons that
	 * specify the amino acid sequence of the protein that
	 * the gene codes for (see Figure 1.17). The ORF begins
	 * with an initiation codon - usually (but not always)
	 * ATG - and ends with a termination codon: TAA, TAG or 
	 * TGA (Section 3.3.2). Searching a DNA sequence for 
	 * ORFs that begin with an ATG and end with a termination 
	 * triplet is therefore one way of looking for genes.
	 * 
	 * https://www.ncbi.nlm.nih.gov/books/NBK21136/
	 */
	
	public boolean codesForProtein(String strand) {
		int start = strand.indexOf("ATG");
		int end = strand.indexOf("TGA");
		if (start == -1) { return false; }
		if (end == -1) { return false; }
		return (start < end);
	}
	
}
