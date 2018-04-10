import java.time.Instant;
import java.util.Map;

public class VirustotalResponse {
	
	 private long responsecode;
	 private boolean message;
	 private String verbosemsg;
	 private String resource;
	 private String scanid;
	 private String md5;
	 private String sha1;
	 private String sha256;
	 private String scandate;
	 private String permalink;
	 private long positive;
	 private long total;
	 private float percent;
	 private Instant instant;
	 private Map avs;

	
	 public VirustotalResponse(long responsecode, boolean message, String verbosemsg, String resource,
			 String scanid, String md5, String sha1, String sha256, String scandate, String permalink, long positive,
			 long total, float percent, Instant instant, Map avs ) {
			super();
			this.responsecode = responsecode;
			this.message = message;
			this.verbosemsg = verbosemsg;
			this.resource = resource;
			this.scanid = scanid;
			this.md5 = md5;
			this.sha1 = sha1;
			this.sha256 = sha256;
			this.scandate = scandate;
			this.permalink = permalink;
			this.positive = positive;
			this.total = total;
			this.percent = percent;
			this.instant = instant;
			this.avs = avs;
		}	 
	 
	 public long getResponsecode() {
		 return responsecode;
	 }
	 public void setResponsecode(long responsecode) {
		 this.responsecode = responsecode;
		 
	 }
	 public boolean getMessage() {
		 return message;
	 }
	 public void setMessage(boolean message) {
		 this.message = message;
		 
	 }
	 public String getverbosemsg() {
		 return verbosemsg;
	 }
	 public void setverbosemsg(String verbosemsg) {
		 this.verbosemsg = verbosemsg;
	 }
	 public String resource() {
		 return resource;
	 }
	 public void setresource(String resource) {
		 this.resource = resource;
	 }
	 public String getscanid() {
		 return scanid;
	 }
	 public void setscanid(String scanid) {
		 this.scanid = scanid;
	 }
	 public String getmd5() {
		 return md5;
	 }
	 public void setmd5(String md5) {
		 this.md5 = md5;
	 }
	 public String getsha1() {
		 return sha1;
	 }
	 public void setsha1(String sha1) {
		 this.sha1 = sha1;
	 }
	 public String getsha256() {
		 return sha256;
	 }
	 public void setsha256(String sha256) {
		 this.sha256 = sha256;
	 }
	 public String getscandate() {
		 return scandate;
	 }
	 public void setscandate(String scandate) {
		 this.scandate = scandate;
	 }
	 public String getpl() {
		 return permalink;
	 }
	 public void setpl(String permalink) {
		 this.permalink = permalink;
	 }
	 public long getpos() {
		 return positive;
	 }
	 public void setpos(long positive) {
		 this.positive = positive;
	 }
	 public long gettotal() {
		 return total;
	 }
	 public void settotal(long total) {
		 this.total = total;
	 }
	 public float getperc() {
		 return percent;
	 }
	 public void setperc(float percent) {
		 this.percent = percent;
	 }
	 public Instant getinst() {
		 return instant;
	 }
	 public void setinst(Instant instant) {
		 this.instant = instant;
	 }
	 public Map getavs() {
		 return avs;
	 }
	 public void setavs(Map avs) {
		 this.avs = avs;
	 }

	@Override
	public String toString() {
		return "VirustotalResponse [responsecode=" + responsecode + ", message=" + message 
				+ ", verbosemsg=" + verbosemsg + ", resource=" + resource + ", scanid=" + scanid + ", md5="
				+ md5 + ", sha1=" + sha1 + ", sha256=" + sha256 + ", scandate=" + scandate + ", permalink=" + permalink
				+ ", positive=" + positive + ", total=" + total + ", percent=" + percent + ", instant="
				+ instant + ", avs=" + avs+ "]";
	}
}