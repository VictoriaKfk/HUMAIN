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

public class CSVabsence {

	static String filename = "requierments.csv";
	static Path pathToFile = Paths.get(filename);
	
	public int readreqCSV(String type, int JustifiedAbsence) throws IOException, CsvException {
    	try (
                Reader reader = Files.newBufferedReader(pathToFile.toAbsolutePath());
                CSVReader csvReader = new CSVReader(reader);
            ) {
            	List<String[]> records = csvReader.readAll();
            	for(String[] s: records) {
                	if(type.contentEquals(s[0])) {
                		JustifiedAbsence = Integer.parseInt(s[2]);
                		//to remove row: readed.remove(s);
                		break;
                		
                	}
            	}
    	}
		return JustifiedAbsence;
	} 
	
	public List<String[]> readCSV() throws IOException, CsvException {
    	try (
                Reader reader = Files.newBufferedReader(pathToFile.toAbsolutePath());
                CSVReader csvReader = new CSVReader(reader);
            ) {
            	List<String[]> records = csvReader.readAll();
            	return records;
            }
            
    } 
    
    public void updateCSV(String ID, String month, int notJ, int JA) throws IOException, CsvException {
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
         }
    }
}
