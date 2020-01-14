import java.util.ArrayList;

public class AttendanceTracker { 
	
	
	private String ID; 
	//maybe use a "department" field
	private static ArrayList<Integer> weekHours = new ArrayList<Integer>(7); // ArrayList saving weekly working hours of an employee
	private static ArrayList<Integer> seasonHours = new ArrayList<Integer>(12); // ArrayList saving monthly working hours of an employee for a season
	private static ArrayList<Integer> seasonHoursLeft = new ArrayList<Integer>(12); // ArrayList saving monthly working hours an employee was absent, for a season (with delays also)
	private static ArrayList<Integer> seasonFullDayAbsences = new ArrayList<Integer>(12); // ArrayList saving whole days per month an employee was absent
	private static ArrayList<Integer> weekFullDayAbsences = new ArrayList<Integer>(7); // ArrayList saving whole days per week an employee was absent

	public AttendanceTracker(String ID) { //constructor with ID only
		this.ID = ID;
	}
		
	public AttendanceTracker(String ID, ArrayList<Integer> seasonH) { // constructor with 2 arguments (ID and seasonHours ArrayList)
		this.ID = ID;
		seasonH = seasonHours;
	}
	
	public AttendanceTracker(String ID, ArrayList<Integer> seasonFDA, ArrayList<Integer> seasonH) { // constructor with 3 arguments (ID, fullDayAbsences, seasonHours ArrayList)
		this.ID = ID;
		seasonHours = seasonH;
	}
	
	public AttendanceTracker(String ID, ArrayList<Integer> weekH, ArrayList<Integer> seasonH,
			ArrayList<Integer> seasonHL, ArrayList<Integer> seasonFDA, ArrayList<Integer> weekFDA) {
		this.ID = ID;
		weekHours= weekH;	
		seasonHours = seasonH;
		seasonHoursLeft = seasonHL;
		seasonFullDayAbsences = seasonFDA;
		weekFullDayAbsences = weekFDA;
		}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
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
