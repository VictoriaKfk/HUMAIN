package setAttendance;

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

public class AttendanceCSV {
	
	/**
	 * Reading and editing CSV.
	 */
	
	static String filename = "AttendanceCSV.csv";
	static Path pathToFile = Paths.get(filename);
	
	public AttendanceCSV() { //default constructor
	}
		
	 public static List<String[]> readCSV() throws IOException, CsvException {
	    	try (
	                Reader reader = Files.newBufferedReader(pathToFile.toAbsolutePath());
	                CSVReader csvReader = new CSVReader(reader);
	            ) {
	            	List<String[]> records = csvReader.readAll();
	            	return records;
	            }
	            
	    } 
	    
	    public static void updateCSV(String ID, String month, int hoursLeft, int hoursWorked) throws IOException, CsvException {
	    	List<String[]> readed = readCSV();
	        try (
	        		CSVWriter writer = new CSVWriter(new FileWriter(filename, false));
	            ) {
	                for(String[] s: readed) {
	                	if(s[0].contentEquals(ID) && s[1].contentEquals(month)) {
	                		s[2] = String.valueOf(hoursLeft);
	                		s[3] = String.valueOf(hoursWorked);
	                		//to remove row: readed.remove(s);
	                		break;
	                		
	                	}
	                }
	                
	                writer.writeAll(readed);
	        }
	    }
	}	

