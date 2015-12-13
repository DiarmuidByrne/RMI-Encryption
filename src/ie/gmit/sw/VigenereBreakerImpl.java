package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VigenereBreakerImpl extends UnicastRemoteObject implements VigenereBreaker{
	private static final long serialVersionUID = 1L;
	private KeyEnumerator breaker;
	private VigenereBreaker vb;
	private int maxKeyLength;
	private String cypherText;
	
	@SuppressWarnings("deprecation")
	public VigenereBreakerImpl() throws Exception {
		breaker = new KeyEnumerator();
		//UnicastRemoteObject.exportObject(this);
	}
		
	public VigenereBreakerImpl(int maxKeyLength, String cypherText) throws RemoteException {
		super();
		this.maxKeyLength = maxKeyLength;
		this.cypherText = cypherText;
	}
		
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException {
		KeyEnumerator s = null;
		try {
			s = new KeyEnumerator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s.crackCypher(cypherText, maxKeyLength).toString();
	}
	
}
