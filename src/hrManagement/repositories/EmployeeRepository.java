package hrManagement.repositories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import hrManagement.domain.Employee;


public class EmployeeRepository {
	
    private static final String TABLE = "\\data\\empoyee.csv";
    private static final String TEMP_TABLE = "\\data\\empoyee_temp.csv";
    
    //return object employee searching by id
    public Employee getByEmployeeId(String employeeId) {
    	
    	String csvFile = System.getProperty("user.dir") + TABLE;
	      String line = "";
	      String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        	
	            while ((line = br.readLine()) != null) {

	                String[] dataArray = line.split(cvsSplitBy);
	                if (dataArray[0].equals(employeeId)) {
	                	
	                	return new Employee(dataArray[0], dataArray[1], dataArray[2],
								            dataArray[3],dataArray[4], dataArray[5],
								            dataArray[6], dataArray[7], dataArray[8], dataArray[9]);
	                } 
	                
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
    	
    }
    
	//creates and returns a list of employees from emplyee.csv file
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		String csvFile = System.getProperty("user.dir") + TABLE;
	      String line = "";
	      String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        	
	            while ((line = br.readLine()) != null) {
                    if(line.length() >= 10) {
	                String[] dataArray = line.split(cvsSplitBy);
	                employeeList.add(new Employee(dataArray[0], dataArray[1], dataArray[2], dataArray[3],dataArray[4], dataArray[5], dataArray[6], dataArray[7], dataArray[8], dataArray[9])); 
                    } 
	            }return employeeList;
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	
	//adds an new employee to the employee.csv file
	public void addEmployee(Employee employee) {
		String csvFile = System.getProperty("user.dir") + TABLE;
		try {
			FileWriter fileWriter = new FileWriter(csvFile,true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.newLine();
			bw.write(employee.getId());
			bw.write(",");
			bw.write(employee.getName());
			bw.write(",");
			bw.write(employee.getLastname());
			bw.write(",");
			bw.write(employee.getDoh());
			bw.write(",");
			bw.write(employee.getEmail());
			bw.write(",");
			bw.write(employee.getAddress());
			bw.write(",");
			bw.write(employee.getPhone());
			bw.write(",");
			bw.write(employee.getDepartment());
			bw.write(",");
			bw.write(employee.getFulltime());
			bw.write(",");
			bw.write(employee.isManager());
			
			bw.close();

		}catch(IOException x) {
			System.out.println("Error writing to file");
		}
		
	}
	
	//delete a a record from the employee.csv file
	public void deleteEmployee(String id) throws IOException {
		
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
	
	public void updateEmployee(Employee employee) throws IOException {
		deleteEmployee(employee.getId());
		addEmployee(employee);  	
	}
}
