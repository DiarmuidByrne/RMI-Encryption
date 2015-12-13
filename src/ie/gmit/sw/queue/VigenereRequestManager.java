package ie.gmit.sw.queue;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VigenereRequestManager {
	// Total amount allowed to use the queue at a time
	private static final int maxCapacity = 10;
	// Queue that supports wait operations when retrieving an element - The IN
	// Queue
	private BlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(maxCapacity);
	// Returning result of decryption - The OUT Map
	private Map<Long, String> out = new ConcurrentHashMap<Long, String>();
	private String cypherText;
	VigenereHandler handler;
	
	public VigenereRequestManager()
	{
		super();
	}
	
	public void remove(long jobNo) {
		out.remove(jobNo);
	}

	public void add(Request r) {
		try {
			// queue.put(r)//blocks if queue full
			new Thread(new Runnable() {
				public void run() {
					try {
						queue.put(r);
						System.out.println("REQUEST: " + r);
						out.put(r.getJobNumber(), r.getCypherText());

						handler = new VigenereHandler(queue, out);
						out.put(r.getJobNumber(), handler.returnResult());

					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}).start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getResult(long jobNumber) {

		new Thread(new Runnable() {
			public void run() {
				try {
					String result = out.get(jobNumber);
					cypherText = result;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		return cypherText;
	}
}
