
import java.util.ArrayList;

public class Daysoff extends AttendanceTracker {
	
	public int daysoff;
	public static int maxDO = 0;
	public static int maxAS = 0;
	public static int maxWFH = 0;
	public static int maxWF= 0;
	public static int JustifiedAbsence = 0;
	public static int AbsenceSick = 0;
	public static int WorkFromHome = 0;
	public static int WorkField = 0;
	
	
	public Daysoff(String ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}
	
	public int daysoff(ArrayList<Integer> seasonHours) {
		for (int m = 1; m <= 12; m++) { 
			if (seasonHours.get(m) > 32) {
				daysoff = 3;
			}
		}
		return daysoff;
	}
	
	public int countdaysoff(int maxDO) {
		maxDO--;
		return maxDO;
	}
	public static int countabsences(ArrayList<Integer> seasonFullDayAbsences) {
		int absences = 0;
		for (int i=0; i<=11; i++) {
			absences = seasonFullDayAbsences.get(i);
			absences--;
		}
		return absences;
	}

	public static int justifiedAbsence(int JustifiedAbsence) {
		JustifiedAbsence += AbsenceSick + WorkFromHome + WorkField;
		return JustifiedAbsence;	
	}
	public int absenceSick() {
		AbsenceSick++;
		return AbsenceSick;
	}
	public int workFromHome() {
		WorkFromHome++;
		return WorkFromHome;
	}
	public int workField() {
		WorkField++;
		return WorkField;
	}
	

}	

