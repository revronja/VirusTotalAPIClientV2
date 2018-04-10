import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeDifference {
	public static LocalDateTime now;
	public static LocalDateTime DateTimeTwo;
	public static LocalDateTime NewDateTime;
	public static int hr;
	public static int mn;
	public static Period time;
	public static LocalDateTime b;
	public static LocalDateTime a;
	public static Period c;
	
	public static LocalDateTime FormatDateString(String DateTimeTwo) throws DateTimeParseException{
		 try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	            NewDateTime = LocalDateTime.parse(DateTimeTwo, formatter);
	        } catch (DateTimeParseException exc) {
	            System.out.printf("%s is not parsable!%n", NewDateTime);
	            throw exc;
	        }
		 return NewDateTime;
	}
	
	public static Period TimeDiffer(LocalDateTime a, LocalDateTime b) {
		   hr = a.getHour() - b.getHour();
		   System.out.println(hr);
	       mn = a.getMinute() - b.getMinute();

	       time = Period.between(a.toLocalDate(), b.toLocalDate());

	       System.out.print("Age is: "+time.getYears()+ " years,"+time.getMonths()+ " months, " +time.getDays()+ " days, "+hr+ " hours, " +mn+ " minutes old");
	
	       return time;
	}

	public static void main(String[] args) {
//		LocalDateTime b;
//		LocalDateTime a;
//		Period c;
		a = LocalDateTime.now();
		//TimeDifference a = new TimeDifference();
		
		b = TimeDifference.FormatDateString("2010-05-15 03:38:44");
		c = TimeDifference.TimeDiffer(a,b);
		System.out.println(c.getYears());
		
		
		
		
		
		// TODO Auto-generated method stub
		//String str = "2010-05-15 03:38:44";
		 //LocalDateTime date = LocalDateTime.now();
		 //System.out.println(date);
		 //try {
	      //      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
	     //       String dateText = date.format(formatter);
	    //        System.out.println(dateText);
	    //    } catch (DateTimeException exc) {
	    //        System.out.printf("%s can't be formatted!%n", date);
	    //        throw exc;
	    //    }
		 // str2 will be supplied by main as arg
		// String str2 = "2010-05-15 03:38:44";
		// System.out.println(str2);
		// LocalDateTime date2 = null;
		// try {
	   //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	   //         date2 = LocalDateTime.parse(str2, formatter);
	   //         System.out.printf("%s%n", date2);
	   //     } catch (DateTimeParseException exc) {
	   //         System.out.printf("%s is not parsable!%n", date2);
	   //         throw exc;
	    //    }
		
		 //long minutes = ChronoUnit.MINUTES.between(date2, date);
		 //long hours = ChronoUnit.HOURS.between(date2, date);
		 //System.out.println(minutes);
		 //System.out.println(hours);
		  // int hr = date.getHour() - date2.getHour();
	    //   int mn = date.getMinute() - date2.getMinute();

	    //   Period time = Period.between(date.toLocalDate(),date2.toLocalDate());

	    //   System.out.print("Age is: "+time.getYears()+ " years,"+time.getMonths()+ " months, " +time.getDays()+ " days, "+hr+ " hours, " +mn+ " minutes old");
	}

}
