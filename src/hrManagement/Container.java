package hrManagement;

import hrManagement.logic.AdminLogic;
import hrManagement.logic.Authentication;
import hrManagement.logic.UserLogic;
import hrManagement.repositories.EmployeeRepository;
import hrManagement.repositories.UserRepository;
import hrManagement.ui.Login;

public class Container {
	
	private Login login;
	
	/* wires the classes,creates objects of classes to be used in a unique main method
	instead of creating them using different main methods*/
	public void wireDependencies() {
		
		UserRepository userRepository = new UserRepository();
		EmployeeRepository employeeRepository = new EmployeeRepository();
		
		AdminLogic adminLogic = new AdminLogic(employeeRepository);
		Authentication authentication = new Authentication(userRepository,employeeRepository);
		UserLogic userLogic = new UserLogic(userRepository,employeeRepository);
		
		login = new Login(authentication);		
	}
	
	public Login getLogin() {
		return login;
	}
	
}
