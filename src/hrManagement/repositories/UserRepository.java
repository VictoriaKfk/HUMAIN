package hrManagement.repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import hrManagement.domain.Employee;
import hrManagement.domain.User;

public class UserRepository {
	
	private static final String TABLE = "/data/user.csv";
	private static final String TEMP_TABLE = "\\data\\temp.csv";
	
	
	//returns a user object searching it by name
	public User getByUserName(String userName) {
		
		String csvFile = System.getProperty("user.dir") + TABLE;
	      String line = "";
	      String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] dataArray = line.split(cvsSplitBy);
	                if (dataArray[1].equals(userName)) {
	                	return new User(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
	                } 
	                
	            }
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
	public String getIDByUserPassUname(String pass, String uname) {
		
		String csvFile = System.getProperty("user.dir") + TABLE;
	      String line = "";
	      String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] dataArray = line.split(cvsSplitBy);
	                if (dataArray[1].equals(uname) && dataArray[2].equals(pass)) {
	                	return dataArray[0];
	                } 
	                
	            }
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "";
	}
	//creates and returns a list of users reading the user.csv file
	public ArrayList<User>  getAllUsers(){
		ArrayList<User> userList = new ArrayList<User>();
		
		String csvFile = System.getProperty("user.dir") + TABLE;
	      String line = "";
	      String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                String[] dataArray = line.split(cvsSplitBy);
	               
	                	userList.add(new User(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]));
	                } return userList;
	                
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}
	
	/*returns for the specific username the security question
	in case of reseting the password*/
	public String getSecurityQuestion(String userName) {
		if(getByUserName(userName) != null) {
			return getByUserName(userName).getQuestion();
		}else {
			return "";
		}
	}
	 
	/*returns for the specific username the security answer
	in case of reseting the password*/
	public String getSecurityAnswer(String userName) {
		if(getByUserName(userName) != null) {
			return getByUserName(userName).getAnswer();
		}else {
			return "";
		}
	}
	
	//returns the role of the user with the specific username
	public String getRole(String userName) {
		return getByUserName(userName).getRole();
		
	}
	
	//adds a new user to the user.csv file
	public void addUser(User user) {
		String csvFile = System.getProperty("user.dir") + TABLE;
		try {
			FileWriter fileWriter = new FileWriter(csvFile,true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.newLine();
			bw.write(user.getId());
			bw.write(",");
			bw.write(user.getUserName());
			bw.write(",");
			bw.write(user.getPassword());
			bw.write(",");
			bw.write(user.getRole());
			bw.write(",");
			bw.write(user.getQuestion());
			bw.write(",");
			bw.write(user.getAnswer());
			
			
			bw.close();

		}catch(IOException x) {
			System.out.println("Error writing to file");
		}
		
	}
	
	public void deleteUser(String id) throws IOException {
		
		File inputFile = new File(System.getProperty("user.dir") + TABLE);
		File tempFile = new File(System.getProperty("user.dir") + TEMP_TABLE);

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String[] trimmedLine = currentLine.split(",");
		    if(trimmedLine.length > 0  && !trimmedLine[0].equals(id)) {
		    	writer.write(currentLine + System.getProperty("line.separator"));
		    }
		}
		writer.close(); 
		reader.close(); 
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		
		
	}
	
	public void updateUser(User user) throws IOException {
		deleteUser(user.getId());
		addUser(user);  	
	}

	
	public User getUserById(String id) {
		String csvFile = System.getProperty("user.dir") + TABLE;
	      String line = "";
	      String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] dataArray = line.split(cvsSplitBy);
	                if (dataArray[0].equals(id)) {
	                	return new User(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
	                } 
	                
	            }
	            

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;

		
	}
		
		     	            
}
