package daysofsetter;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

public class MainClass {
	public static void main(String[] args) throws IOException, CsvException {
		DaysOffSetter dos = new DaysOffSetter();
		DaysOffSetterGUI dosGUI = new DaysOffSetterGUI(dos);
		DaysOffSetterCSV doscsv = new DaysOffSetterCSV();
		dosGUI.runGUI(dos);
	}
}
