package hrManagement.logic;

import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvException;

import hrManagement.domain.Employee;
import hrManagement.repositories.EmployeeRepository;

public class AdminLogic {
	
	private EmployeeRepository employeeRepository;
	
	//constructor
	public AdminLogic(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	public ArrayList<Employee> getAllData(){
		return employeeRepository.getAllEmployees();
	}
	
	
	
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}
	
    public void deleteEmployeeRecord(String id) throws CsvException, IOException {
    	employeeRepository.deleteEmployee(id);
    }
    
    public void updateEmployeeRecord(Employee employee) throws IOException {
    	employeeRepository.updateEmployee(employee);
    }
    
    
}
