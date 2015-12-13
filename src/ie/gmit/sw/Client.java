package ie.gmit.sw;

import java.rmi.Naming;

public class Client {
	
	
	public static void main(String[] args) throws Exception {
		/*
		 * This stuff needs to be in your tomcat app
		 */		
		// Looks up registry for VigenereService. Returns object with parameters
		VigenereService vs = (VigenereService) Naming.lookup("cypher-service");
		
		// Instantiates VigenereBreaker 
		VigenereBreaker vb = vs.getVigenere();
		
		String result = vb.getDecryption(vb);
		System.out.println(result);
	}
}
