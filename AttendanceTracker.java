
import java.util.ArrayList;

public class AttendanceTracker { 
	
	
	private int ID; 
	//maybe use a "department" field
	private static ArrayList<Integer> weekHours = new ArrayList<Integer>(7); // ArrayList saving weekly working hours of an employee
	private static ArrayList<Integer> seasonHours = new ArrayList<Integer>(12); // ArrayList saving monthly working hours of an employee for a season
	private static ArrayList<Integer> seasonHoursLeft = new ArrayList<Integer>(12); // ArrayList saving monthly working hours an employee was absent, for a season (with delays also)
	private static ArrayList<Integer> seasonFullDayAbsences = new ArrayList<Integer>(12); // ArrayList saving whole days per month an employee was absent
	private static ArrayList<Integer> weekFullDayAbsences = new ArrayList<Integer>(7); // ArrayList saving whole days per week an employee was absent

	public AttendanceTracker(int ID) { //constructor with ID only
		if ((ID <= 1000) || (ID >= 2800)) {
			throw new IllegalArgumentException("ID must be: 1001 >= ID >= 2799");
		}
		this.ID = ID;
	}
		
	public AttendanceTracker(int ID, ArrayList<Integer> seasonH) { // constructor with 2 arguments (ID and seasonHours ArrayList)
		if ((ID <= 1000) || (ID >= 2800)) {
			throw new IllegalArgumentException("ID must be: 1001 >= ID >= 2799");
		}
		this.ID = ID;
		seasonH = seasonHours;
	}
	
	public AttendanceTracker(int ID, ArrayList<Integer> seasonFDA, ArrayList<Integer> seasonH) { // constructor with 3 arguments (ID, fullDayAbsences, seasonHours ArrayList)
		if ((ID <= 1000) || (ID >= 2800)) {
			throw new IllegalArgumentException("ID must be: 1001 >= ID >= 2799");
		}
		this.ID = ID;
		seasonHours = seasonH;
	}
	
	public AttendanceTracker(int ID, ArrayList<Integer> weekH, ArrayList<Integer> seasonH,
			ArrayList<Integer> seasonHL, ArrayList<Integer> seasonFDA, ArrayList<Integer> weekFDA) {
		if ((ID <= 1000) || (ID >= 2800)) {
			throw new IllegalArgumentException("ID must be: 1001 >= ID >= 2799");
		}
		this.ID = ID;
		weekHours= weekH;	
		seasonHours = seasonH;
		seasonHoursLeft = seasonHL;
		seasonFullDayAbsences = seasonFDA;
		weekFullDayAbsences = weekFDA;
		}
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		if ((ID <= 1000) || (ID >= 2800)) {
			throw new IllegalArgumentException("About ID: 1001 >= ID >= 2799");
		}
		this.ID = ID;
	}

	public void displayDailyProgramm() { // Displays the daily week schedule of every employee, based on his ID (EXAMPLE)
		if (ID <= 1299) {
			System.out.print("**MARKETING DEPARTMENT WEEK SCHEDULE**/n" 
								+ "Monday: 	  8:00 until 16:00/n"
								+ "Tuesday:   8:00 until 16:00/n"
								+ "Wednesday: 8:00 until 16:00/n"
								+ "Thursday:  8:00 until 16:00/n"
								+ "Friday:    8:00 until 16:00/n"
								+ "Saturday:  8:00 until 16:00/n"
								+ "Sunday: 		Day Off/n");
		} else if (ID <= 1599) {
			System.out.print("**OPERATIONS DEPARTMENT WEEK SCHEDULE**\n" 
					+ "Monday: 	  9:00 until 17:00\n"
					+ "Tuesday:   9:00 until 17:00\n"
					+ "Wednesday: 9:00 until 17:00\n"
					+ "Thursday:  9:00 until 17:00\n"
					+ "Friday:    9:00 until 17:00\n"
					+ "Saturday:  9:00 until 17:00\n"
					+ "Sunday: 	Day Off\n");
		} else if(ID <= 1899) {
			System.out.print("**FINANCE DEPARTMENT WEEK SCHEDULE**\n" 
					+ "Monday: 	  9:00 until 17:00\n"
					+ "Tuesday:   9:00 until 17:00\n"
					+ "Wednesday: 9:00 until 17:00\n"
					+ "Thursday:  9:00 until 17:00\n"
					+ "Friday:    9:00 until 17:00\n"
					+ "Saturday:  9:00 until 17:00\n"
					+ "Sunday: 	Day Off\n");
		} else if(ID <= 2199) {
			System.out.print("**SALES DEPARTMENT WEEK SCHEDULE**\n" 
					+ "Monday: 	  8:00 until 16:00\n"
					+ "Tuesday:   8:00 until 16:00\n"
					+ "Wednesday: 8:00 until 16:00\n"
					+ "Thursday:  8:00 until 16:00\n"
					+ "Friday:    8:00 until 16:00\n"
					+ "Saturday:  8:00 until 16:00\n"
					+ "Sunday: 		Day Off\n");
		} else if(ID <= 2499) {
			System.out.print("**HUMAN RESOURCE DEPARTMENT WEEK SCHEDULE**\n"
					+ "Monday: 	  9:00 until 17:00\n"
					+ "Tuesday:   9:00 until 17:00\n"
					+ "Wednesday: 9:00 until 17:00\n"
					+ "Thursday:  9:00 until 17:00\n"
					+ "Friday:    9:00 until 17:00\n"
					+ "Saturday:  9:00 until 17:00\n"
					+ "Sunday: 	Day Off\n");
		} else {
			System.out.print("**PURCHASE DEPARTMENT WEEK SCHEDULE**\n"
					+ "Monday: 	  8:00 until 16:00\n"
					+ "Tuesday:   8:00 until 16:00\n"
					+ "Wednesday: 8:00 until 16:00\n"
					+ "Thursday:  8:00 until 16:00\n"
					+ "Friday:    8:00 until 16:00\n"
					+ "Saturday:  8:00 until 16:00\n"
					+ "Sunday: 	Day Off\n");
		} // end if...else
	} // end displayDailyProgramm
	
	/*After log in, the user must select the "Just arrived" RadioBox and on his way out, he must select the "I'm leaving" RadioBox*/

	public void weekTracker(int dailyHours) { // Parameter "dailyHours" will be taken from AttendanceCheckMenu GUI class (method hoursPerDay)
				weekHours.add(dailyHours);   
			if (dailyHours == 0) {
				weekFullDayAbsences.add(1);	
			}
		}
	
	public void seasonTracker(int totalWeekHours, int monthsOfYear) { 
			for (int w = 1; w <= 4; w++) {
				seasonHours.add(monthsOfYear, seasonHours.get(monthsOfYear) + totalWeekHours);
				for (int d = 0; d <= 6; d++) {
					seasonFullDayAbsences.add(monthsOfYear, seasonFullDayAbsences.get(monthsOfYear) + weekFullDayAbsences.get(d));
				}
				if (seasonHours.get(monthsOfYear) < 160) { // TODO 160 is  optional (I must use the exact hours per week an employee should normally work, according to his schedule)
					seasonHoursLeft.add(monthsOfYear, 160 - seasonHours.get(monthsOfYear));
				}
			}
		}
	} // end AttendanceTracker