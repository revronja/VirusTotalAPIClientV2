import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test_CSVWriter {

	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "responsecode,message,verbosemsg,resource,scanid,md5,sha1,sha256,scandate,permalink,positive,total,percent,instant";

			
	public static void writeCsvFile(String fileName) {
		
		//Create new objects

	     
	     // load all these fields into VirustotalResponse as params
		
     VirustotalResponse resp1 = new VirustotalResponse( Test_RestAPIClient01.responsecode, Test_RestAPIClient01.message, Test_RestAPIClient01.verbosemsg, Test_RestAPIClient01.resource,
    		 Test_RestAPIClient01.scanid, Test_RestAPIClient01.md5, Test_RestAPIClient01.sha1, Test_RestAPIClient01.sha256, Test_RestAPIClient01.scandate, 
    		 Test_RestAPIClient01.permalink, Test_RestAPIClient01.positive,	
    		 Test_RestAPIClient01.total, Test_RestAPIClient01.percent, Test_RestAPIClient01.instant, Test_RestAPIClient01.avs);
	     
	     Iterator<Map.Entry> itr1 = Test_RestAPIClient01.avs.entrySet().iterator();
	        while (itr1.hasNext()) {
	           Map.Entry pair = itr1.next();
	           System.out.println(pair.getKey() + " : " + pair.getValue());
	        }
	     
		
		
		
		//CustomResponse response1 = new CustomResponse(1, true);
//		Student student1 = new Student(1, "Ahmed", "Mohamed", "M", 25);
//		Student student2 = new Student(2, "Sara", "Said", "F", 23);

		
		//Create a new list of student objects
//		List students = new ArrayList();
//		students.add(student1);
//		students.add(student2);
		List responses = new ArrayList();
		responses.add(resp1);

//		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (Object response : responses) {
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getResponsecode()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getMessage()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getverbosemsg()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).resource()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getscanid()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getmd5()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getsha1()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getsha256()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getscandate()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getpl()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getpos()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).gettotal()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getperc()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getinst()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((VirustotalResponse) response).getavs()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}