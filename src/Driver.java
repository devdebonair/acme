import java.util.Calendar;
import java.util.Date;

public class Driver {
	static Department dept = new Department("123", DepartmentType.Production);
	
	public static void main(String[] args) {
		String code = "123";
		
		dept.addEmployee(code, "Vincent Moore");
		
		// Set hours
		dept.punch(code, HourType.Vacation, 1, 8, 0);
		dept.punch(code, HourType.Regular, 2, 12, 0);
		dept.punch(code, HourType.Regular, 3, 10, 0);
		dept.punch(code, HourType.Regular, 4, 10, 0);
		dept.punch(code, HourType.Regular, 5, 10, 0);
		dept.punch(code, HourType.Callback, 6, 2, 0);
		
		// Check hours
		Date[] dates = new Date[7];
		for(int i = 0; i < dates.length; i++) {
			dates[i] = getDate(i+1,0,0);
		}

		Timesheet sheet = dept.getTimesheet(code, dates);
		System.out.println(sheet.getHoursWorked());
	}

	public static Ticket punch(String id, HourType type, int day, int hour, int minute) {
		Date date = getDate(day, hour, minute);
		Ticket ticket = dept.punch(id, type, date);
		return ticket;
	}

	public static Date getDate(int day, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}