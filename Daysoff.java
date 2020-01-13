import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class Daysoff extends AttendanceTracker {
	
	public int daysoff;
	public int JustifiedAbsence = 0;
	public int AbsenceSick = 0;
	public int WorkFromHome = 0;
	public int WorkField = 0;
	
	public Daysoff(int ID) {
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
	
	
	static String filename = "requierments.csv";
	static Path pathToFile = Paths.get(filename);
	
	public static List<String[]> readCSV() throws IOException, CsvException {
    	try (
                Reader reader = Files.newBufferedReader(pathToFile.toAbsolutePath());
                CSVReader csvReader = new CSVReader(reader);
            ) {
            	List<String[]> records = csvReader.readAll();
            	return records;
            }
            
    } 
    
    public static void updateCSV(String ID, String month, int notJ, int JA) throws IOException, CsvException {
    	List<String[]> readed = readCSV();
        try (
        		CSVWriter writer = new CSVWriter(new FileWriter(filename, false));
            ) {
                for(String[] s: readed) {
                	if(s[0].contentEquals(ID) && s[1].contentEquals(month)) {
                		s[6] = String.valueOf(notJ);
                		s[7] = String.valueOf(JA);
                		//to remove row: readed.remove(s);
                		break;
                		
                	}
                }
                
                writer.writeAll(readed);
        }
    }
}	

