package setDaysOffLimits;

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

public class DaysOffSetterCSV {
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
    
    public static void updateCSV(String update, boolean switcher, int numdays) throws IOException, CsvException {
    	List<String[]> readed = readCSV();
        try (
        		CSVWriter writer = new CSVWriter(new FileWriter(filename, false));
            ) {
                for(String[] s: readed) {
                	if(s[0].contentEquals(update)) {
                		s[1] = String.valueOf(switcher);
                		s[2] = String.valueOf(numdays);
                		//to remove row: readed.remove(s);
                		break;
                		
                	}
                }
                
                writer.writeAll(readed);
        }
    }
}	

