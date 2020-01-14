import static java.util.Calendar.HOUR_OF_DAY;
import java.util.Calendar;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

/*After log in, the user must select the "Just arrived" RadioBox and on his way out, he must select the "I'm leaving" RadioBox*/
public class AttendanceCheckMenu extends JFrame { // this GUI frame is going to pop up 2 times per working day (at the beginning and at the end of each one)

	private JPanel contentPane;
	Calendar cal = Calendar.getInstance();
	static int arrivaltime, exittime = 0;
	static int daysOfWeek = 0; //continue counting!!! (using fields)
	static int totalWeekHours = 0;
	static int monthsOfYear = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws  IOException, CsvException { //TODO declare lists and tables...
		
		ArrayList<Integer> weekHours = new ArrayList<Integer>(7);
		ArrayList<Integer> seasonHours = new ArrayList<Integer>(12);
		ArrayList<Integer> seasonHoursLeft = new ArrayList<Integer>(12);
		ArrayList<Integer> seasonFullDayAbsences = new ArrayList<Integer>(12);
		ArrayList<Integer> weekFullDayAbsences = new ArrayList<Integer>(7);
		
		AttendanceTracker at = new AttendanceTracker(2439, weekHours, seasonHours, seasonHoursLeft, seasonFullDayAbsences, weekFullDayAbsences);
		at.displayDailyProgramm();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendanceCheckMenu frame = new AttendanceCheckMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true) {
			at.weekTracker(hoursPerDay());
			daysOfWeek++;
			if (daysOfWeek == 6) {
				for (int i = 0; i <= 6; i++) {
					totalWeekHours += weekHours.get(i);
				}
				at.seasonTracker(totalWeekHours, monthsOfYear);
				monthsOfYear++;
				daysOfWeek = 0;
				break;
			}
			for (int countcsv = 1; countcsv <= 12; countcsv++) { //TODO read the ID from csv (maybe in other "main" class)
			updateCSV("hr2", String.valueOf(monthsOfYear), seasonHoursLeft.get(countcsv), seasonHours.get(countcsv));
	    	readCSV();
			}
			if (monthsOfYear == 11) {
				monthsOfYear = 0;
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public AttendanceCheckMenu() { //constructor
		setTitle("Attendance Check");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JRadioButton arrivalbox = new JRadioButton("Just Arrived!");
		arrivalbox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { // handling the actions for the 1st radiobox
				if (e.getSource() == arrivalbox) {
					  if (arrivalbox.isEnabled() == true) {
						  arrivaltime = cal.get(HOUR_OF_DAY);
					  }
				}
			}
		});
		contentPane.add(arrivalbox, BorderLayout.WEST);
		
		JRadioButton exitbox = new JRadioButton("I'm Leaving!");
		exitbox.addActionListener(new ActionListener() { //handling the actions for the 2nd radiobox

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == exitbox) {
					  if (exitbox.isEnabled() == true) {
						 exittime = cal.get(HOUR_OF_DAY);
					  }
				}
			}
		});
		exitbox.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(exitbox, BorderLayout.CENTER);
		
		JButton b = new JButton("OK");
		b.addActionListener(new ActionListener() { //handling the actions for the button "OK"
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b) {
					 System.exit(0);
				 }
			}
		});
		b.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(b, BorderLayout.SOUTH);
	}
	
	 public static int hoursPerDay() { //after(!) every employee finish his daily job, in order to both timechecks not be null!
		 int totalDayH = 0;
		 if ((arrivaltime != 0) && (exittime != 0)) {
				 totalDayH = exittime - arrivaltime;
		 }
		 return totalDayH;
	 }
	 
	 
	 	/**
		 * Reading and editing CSV.
		 */
	 
	 static String filename = "AttendanceCSV.csv";
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
