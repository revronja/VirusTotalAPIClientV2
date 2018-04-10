import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVWriter {

	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	//private static final String FILE_HEADER = "responsecode,message,verbosemsg,resource,scanid,md5,sha1,sha256,scandate,permalink,positive,total,percent,instant";
	private static final String FILE_HEADER = "responsecode,message,verbosemsg";
			
	public static void writeCsvFile(String fileName) {
		
		//Create new students objects
		CustomResponse response1 = new CustomResponse(1, true);
//		Student student1 = new Student(1, "Ahmed", "Mohamed", "M", 25);
//		Student student2 = new Student(2, "Sara", "Said", "F", 23);

		
		//Create a new list of student objects
//		List students = new ArrayList();
//		students.add(student1);
//		students.add(student2);
		List responses = new ArrayList();
		responses.add(response1);

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
				fileWriter.append(String.valueOf(((CustomResponse) response).getResponseCode()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(((CustomResponse) response).getMessage()));
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(student.getLastName());
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(student.getGender());
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(String.valueOf(student.getAge()));
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