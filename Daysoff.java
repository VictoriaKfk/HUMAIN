import java.util.ArrayList;

public class Daysoff extends AttendanceTracker {
	public int daysoff;
	public int JustifiedAbsence = 0;
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
	public int countabsences(int absence) {
		absence--;
		return absence;
	}

	public int JustifiedAbsence (int JustifiedAbsence) {
		int AbsenceSick = 0;
		JustifiedAbsence += AbsenceSick;
		return JustifiedAbsence;	
	}
	

}
