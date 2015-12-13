package ie.gmit.sw;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class VigenereServant {
		
	public static void main(String[] args) throws Exception {
			
		System.out.println("starting remote service");
		LocateRegistry.createRegistry(1099);
		
		VigenereBreaker vb = new VigenereBreakerImpl();
			
		Naming.bind("rmi://localhost:1099/cypher-service", new VigenereServiceImpl(vb));
			
		System.out.println("service started...");
	}	
}