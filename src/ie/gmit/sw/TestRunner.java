package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TestRunner {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("starting remote service");
		
		LocateRegistry.createRegistry(1099);
		//Check out-queue for finished job
		VigenereBreaker vb = new VigenereBreakerImpl(2, 5, "QEGLDMAMKCNSNMNXLYFGREIDXEEXOBNTJCWJTRIIQYJUPPADN");
		
		VigenereService vs = new VigenereServiceImpl(vb);
		
		Naming.bind("cypher-service", vs);
		
		System.out.println("service started...");
	}

}
