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

public class Payroll2 {
	
	public static void main(String[] args) throws IOException, CsvException {
		updateCSV("hr2", "1");
	}
	
	static String filename = "payroll_attendance.csv";
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

	    public static void updateCSV(String ID, String month) throws IOException, CsvException {
	    	List<String[]> readed = readCSV();
	        try (
	        		CSVWriter writer = new CSVWriter(new FileWriter(filename, false));
	            ) {
	                for(String[] s: readed) {
	                	if(s[0].contentEquals(ID) && s[1].contentEquals(month)) {
	                		if (s[5].contentEquals("true")) {
	            				s[8] = String.valueOf((Integer.valueOf(s[3]) * Integer.valueOf(s[4])));
	            			} else if (s[5].contentEquals("false")) {
	            				if (s[6].contentEquals("0")) {
	            					s[8] = s[4];
	            				} else {
	            					s[8] = String.valueOf((Integer.valueOf(s[4]) - (Integer.valueOf(s[4]) * (Integer.valueOf(s[6]) / 22))));
	            				}
	                	 	}
	                		break;

	                	}
	                }

	                writer.writeAll(readed);
	        }
	    }
}