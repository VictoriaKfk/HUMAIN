package setAttendance;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;


public class AttendanceApp {

	public static void main(String[] args)  throws  IOException, CsvException {
		
		ArrayList<Integer> weekHours = new ArrayList<Integer>(7);
		ArrayList<Integer> seasonHours = new ArrayList<Integer>(12);
		ArrayList<Integer> seasonHoursLeft = new ArrayList<Integer>(12);
		ArrayList<Integer> seasonFullDayAbsences = new ArrayList<Integer>(12);
		ArrayList<Integer> weekFullDayAbsences = new ArrayList<Integer>(7);

		 
		AttendanceTracker at = new 
				AttendanceTracker("hr2", weekHours, seasonHours, seasonHoursLeft, seasonFullDayAbsences, weekFullDayAbsences);
		
		AttendanceCheckMenu.rungui(); //GUI pops up
		
		at.weekTracker(hoursPerDay());
		at.daysOfWeek++;
		if (at.daysOfWeek == 6) {
			for (int i = 0; i <= 6; i++) {
				at.totalWeekHours += weekHours.get(i);
			}
			at.daysOfWeek = 0;
			at.weekOfMonth++;
			if (at.weekOfMonth == 3) {
				at.seasonTracker(at.totalWeekHours, at.monthsOfYear);
				at.weekOfMonth = 0;
				AttendanceCSV.updateCSV("hr2", String.valueOf(at.monthsOfYear), seasonHoursLeft.get(at.monthsOfYear), seasonHours.get(at.monthsOfYear));
				AttendanceCSV.readCSV();
				at.monthsOfYear++;
				}
			if (at.monthsOfYear == 11) {
				at.monthsOfYear = 0;
			}
		}
	}
	
	
	public static int hoursPerDay() { //after(!) every employee finish his daily job, in order to both timechecks not be null!
		 int totalDayH = 0;
		 if ((AttendanceCheckMenu.arrivaltime != 0) && (AttendanceCheckMenu.exittime != 0)) {
				 totalDayH = AttendanceCheckMenu.exittime - AttendanceCheckMenu.arrivaltime;
		 }
		 return totalDayH;
	 }
}
