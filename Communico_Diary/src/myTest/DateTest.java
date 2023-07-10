package myTest;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Date date = new Date();
		
		//Calendar.
		System.out.println(LocalDate.now().getDayOfMonth()); 
		System.out.println(LocalDate.now().plusDays(30).getDayOfMonth()); 
		
	}

}
