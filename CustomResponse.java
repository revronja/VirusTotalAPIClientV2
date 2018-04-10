

public class CustomResponse {
	 private long responsecode;
	 private boolean message;
//	 private String verbosemsg;
//	 private String resource;
//	 private String scanid;
//	 private String md5;
//	 private String sha1;
//	 private String sha256;
//	 private String scandate;
//	 private String permalink;
//	 private long positive;
//	 private long total;
//	 private float percent;
//	 private Instant instant;
//	 private Map avs;

	public CustomResponse(long responsecode, boolean message ) {
//	public CustomResponse(long responsecode, boolean message, String verbosemsg, String resource, String scanid, 
//			String md5, String sha1, String sha256, String scandate, String permalink, long positive,
//			long total, float percent, Instant instant, Map avs) {
		super();
		this.responsecode = responsecode;
		this.message = message;
//		this.verbosemsg = verbosemsg;
//		this.resource = resource;
//		this.scanid = scanid;
//		this.md5 = md5;
//		this.sha1 = sha1;
//		this.sha256 = sha256;
//		this.scandate = scandate;
//		this.permalink = permalink;
//		this.positive = positive;
//		this.total = total;
//		this.percent = percent;
//		this.instant = instant;
//		this.avs = avs;
	}

	public long getResponseCode() {
		return responsecode;
	}
	
	public void setResponseCode(long responsecode) {
		this.responsecode = responsecode;
	}
	
	public boolean getMessage() {
		return message;
	}
	
	public void setMessage(boolean message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [responsecode=" + responsecode + ", message" + message+ "]";
	}
}