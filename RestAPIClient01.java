
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;


public class RestAPIClient01 {
	 public static long responsecode;
	 public static boolean message;
	 public static String verbosemsg;
	 public static String resource;
	 public static String scanid;
	 public static String md5;
	 public static String sha1;
	 public static String sha256;
	 public static String scandate;
	 // "last scan was _ days ago."
	 public static String permalink;
	 public static long positive;
	 public static long total;
	 public static float percent;
	 public static Instant instant;
	 public static Map avs;
	 
	 // get JSONArray
	 //public static String permalink;
	
	public void sendGet(String checksum) throws Exception{
		Config conf = new Config();
		String ak = conf.getVirusTotalAPIKey();
	    String url1 = "https://www.virustotal.com/vtapi/v2/file/report?";
	    String url2 = "&resource=" + checksum;
		String url = url1 + ak + url2;
		
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		int statusCode = conn.getResponseCode();
		// if response code is 204 = rate limit reached.
		// Need to add logger functions 
		if (statusCode == 204) {
			Thread.sleep(60000);
		}
		else if (statusCode == 400){
			System.out.println("Bad request made.");
		}
		else if (statusCode == 403) {
			System.out.println("Forbidden.");
		}
		System.out.println("Sending GET req to URL: " + url);
		System.out.println("Status Code: " + statusCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
		
		
		 responsecode = (long) jsonObject.get("response_code");
		 if (responsecode == 1) {
			 message = true;
		 }
		 else {
			 message = false;
		 }
		 
		 verbosemsg = (String) jsonObject.get("verbose_msg");
		 resource = (String) jsonObject.get("resource");
		 //scanid = (String) jsonObject.get("scan_id");
		 md5 = (String) jsonObject.get("md5");
		 sha1 = (String) jsonObject.get("sha1");
	     sha256 = (String) jsonObject.get("sha256");
		 scandate = (String) jsonObject.get("scan_date");
		 // "last scan was _ days ago."
		 permalink = (String) jsonObject.get("permalink");
		 positive = (long) jsonObject.get("positives");
		 total = (long) jsonObject.get("total");
		 percent = (float) ((positive*100/total));
		 instant = Instant.now();
		 avs = (Map) jsonObject.get("scans");
		 
		 
	     conn.disconnect();
	   
	}
	
	
	public static void main(String[] args) {
			RestAPIClient01 client = new RestAPIClient01();
			try{
				// Need logic for what type of checksum is entered = display other fields.
				// test hash is 99017f6eebbac24f351415dd410d522d
			     client.sendGet("99017f6eebbac24f351415dd410d522d");
			     System.out.println("Report found: " + RestAPIClient01.message);
			     System.out.println(RestAPIClient01.responsecode);
			     System.out.println(RestAPIClient01.verbosemsg);
			     System.out.println(RestAPIClient01.resource);
			     //System.out.println(RestAPIClient01.scanid);
			     System.out.println(RestAPIClient01.md5);
			     System.out.println(RestAPIClient01.sha1);
			     System.out.println(RestAPIClient01.sha256);
			     System.out.println(RestAPIClient01.scandate);
			     System.out.println(RestAPIClient01.permalink);
			     System.out.println(RestAPIClient01.positive);
			     System.out.println(RestAPIClient01.total);
			     System.out.println("% of AVs that detected: " + RestAPIClient01.percent);
			
			     //Iterator<Map.Entry> itr1 = avs.entrySet().iterator();
			       // while (itr1.hasNext()) {
			          //  Map.Entry pair = itr1.next();
			          //  System.out.println(pair.getKey() + " : " + pair.getValue());
			       // }
			     
			     
			     
		} catch (Exception e) {
			System.out.println(e + " was thrown.");
		}
			
	}
}


