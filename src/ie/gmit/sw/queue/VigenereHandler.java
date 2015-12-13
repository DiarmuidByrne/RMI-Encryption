package ie.gmit.sw.queue;

import java.rmi.Naming;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import ie.gmit.sw.VigenereBreaker;
import ie.gmit.sw.VigenereService;

public class VigenereHandler {
	private BlockingQueue<Request> queue;
	private Map<Long, String> out = new ConcurrentHashMap<Long, String>();	
	private String result;
	private Request req = null;
	
	public VigenereHandler(BlockingQueue<Request> q, Map<Long, String> out)
	{
		this.out = out;
		this.queue = q;
		run();
	}
	
	public void run()
	{
		try 
		{
			req = queue.take();
		} 
		
		catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			// Import Vigenere jar to receive remote object call
			VigenereService vs = (VigenereService) Naming.lookup("rmi://192.168.1.10:1099/cypher-service");
			
			VigenereBreaker vb = vs.getVigenere();
			result = vb.decrypt(req.getCypherText(),  req.getMaxKeySize());
			System.out.println("VH RESULT: " + result);
			out.put(req.getJobNumber(), result);

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}	
	public String returnResult()
	{
		return out.get(req.getJobNumber());
	}
}
