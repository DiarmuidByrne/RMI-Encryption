package ie.gmit.sw;

import java.rmi.Naming;

public class TestClient {
	
	
	public static void main(String[] args) throws Exception {
		// Looks up registry for VigenereService. Returns object with parameters
		VigenereService vs = (VigenereService) Naming.lookup("cypher-service");
		
		// Instantiates VigenereBreaker 
		VigenereBreaker vb = vs.getVigenere();
		
		String result = vb.getDecryption(vb);
		System.out.println(result);
	}
}
