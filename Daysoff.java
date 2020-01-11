import java.util.ArrayList;

public class Daysoff extends {AttendanceTracker , DaysOffSetter} {
	public int daysoff;
	public int JustifiedAbsence = 0;
	public int AbsenceSick = 0;
	public int WorkFromHome = 0;
	public int WorkField = 0;
	
	public int daysoff(ArrayList<Integer> seasonHours) {
		for (int m = 1; m <= 12; m++) { 
			if (seasonHours.get(m) > 32) {
				daysoff = 3;
			}
		}
		return daysoff;
	}
	public int countdaysoff(int daysoff) {
		daysoff--;
		return daysoff;
	}
	public int countabsences(ArrayList<Integer> seasonFullDayAbsences) {
		int absences = 0;
		for (int i=0; i<=11; i++) {
			absences = seasonFullDayAbsences.get(i);
			absences--;
		}
		return absences;
	}

	public int JustifiedAbsence (int JustifiedAbsence) {
		JustifiedAbsence += AbsenceSick + WorkFromHome + WorkField;
		return JustifiedAbsence;	
	}
	public int AbsenceSick() {
		AbsenceSick++;
		return AbsenceSick;
	}
	public int WorkFromHome() {
		WorkFromHome++;
		return WorkFromHome;
	}
	public int WorkField() {
		WorkField++;
		return WorkField;
	}
}
