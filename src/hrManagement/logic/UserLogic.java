package hrManagement.logic;

import java.util.ArrayList;

import hrManagement.domain.Employee;
import hrManagement.repositories.EmployeeRepository;
import hrManagement.repositories.UserRepository;

public class UserLogic {
	
	private UserRepository userRepository;
	private EmployeeRepository employeeRepository;
	
	public UserLogic(UserRepository userRepository, EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
		this.userRepository = userRepository;
	}
	
	public String getDeptById(String id) {
		   
		   if(id.contains("ex")) {
			   return "Consulting";			   
		   }
		   
		   if(id.contains("m")) {
			   return "Marketing";
		   }
		   if(id.contains("cc")) {
			   return "Customer Care";			   
		   }
		   
		   if(id.contains("f")) {
			   return "Finance";					   
		   }
		   
		   if(id.contains("it")) {
			   return "IT";			   
		   }
		   
		   if(id.contains("hr")) {
			   return "HR";
		   }
			   
		   return "";
	   }
	
	public ArrayList<Employee> getColleagues(String dept){
		ArrayList<Employee> l = employeeRepository.getAllEmployees();
		ArrayList<Employee> colleagues = new ArrayList<Employee>();
		for (int i = 0; i<l.size(); i++) {
			if(l.get(i).getDepartment().equals(dept)) {
				colleagues.add(l.get(i));
			}
		}return colleagues;
	}
	

}
