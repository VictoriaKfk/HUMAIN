import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public class MainClass {
	public static void main(String[] args) throws IOException, CsvException {
		Absence ab = new Absence();
		ab.runGUI();
		CSVabsence csvv = new CSVabsence();
		List<String[]> records = csvv.readCSV();
		Daysoff dof = new Daysoff("hr2");
		dof.maxDO = csvv.readreqCSV("DaysOff", dof.maxDO);
		dof.maxWF = csvv.readreqCSV("FieldWorkDays", dof.maxWF);
		dof.maxAS = csvv.readreqCSV("AbsenceSick", dof.maxAS);
		dof.maxWFH = csvv.readreqCSV("WorkfromHome", dof.maxWFH);
		
		
		//csvv.updateCSV("2439", "month", Daysoff.countabsences(Daysoff.seasonFullDayAbsences), Daysoff.justifiedAbsence(Daysoff.JustifiedAbsence));
		
	}


}
