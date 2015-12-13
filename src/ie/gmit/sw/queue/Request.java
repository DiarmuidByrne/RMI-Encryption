package ie.gmit.sw.queue;

public class Request {
	private String cypherText;
	private int maxKeySize;
	private long jobNumber;
	private String hostIP;
	
	public Request(String cText, int maxNo, long jobNo) {
		setCypherText(cText);
		setMaxKeySize(maxNo);
		setJobNumber(jobNo);
	}

	
//	public Request(String cText, int maxNo, long jobNo, String ip)
//	{
//		setCypherText(cText);
//		setMaxKeySize(maxNo);
//		setJobNumber(jobNo);
//		setHostIP(ip);
//	}

	public String getHostIP() {
		return hostIP;
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}

	public String getCypherText() {
		return cypherText;
	}

	public void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}

	public int getMaxKeySize() {
		return maxKeySize;
	}

	public void setMaxKeySize(int maxKeySize) {
		this.maxKeySize = maxKeySize;
	}

	public long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(long jobNumber) {
		this.jobNumber = jobNumber;
	}
}
