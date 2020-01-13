package hrManagement.logic;

import java.io.IOException;

import hrManagement.domain.User;
import hrManagement.repositories.EmployeeRepository;
import hrManagement.repositories.UserRepository;

public class Authentication {
	
	private UserRepository userRepository;
	private EmployeeRepository employeeRepository;
	
	//constructor
	public Authentication(UserRepository userRepository, EmployeeRepository employeeRepository) {
		this.userRepository = userRepository;
		this.employeeRepository = employeeRepository;
	}
	
    //call method from userRepository
	public boolean login(String userName, String password) {
		User user = userRepository.getByUserName(userName);
		return authenticate(password, user);
		
	}
	
	//checks if the inserted password matches the password in user.csv file
	private boolean authenticate(String password, User targetUser) {
		return targetUser.getPassword().equals(password);
	}
	 
	
	 // Reseting the password //
    public boolean resetMyPassword( String userName, String question, String answer, String newPassword){
    	User user = userRepository.getByUserName(userName);
    	if(userRepository.getSecurityQuestion(userName).equals(question) && userRepository.getSecurityAnswer(userName).equals(answer)) {
    		user.setPassword(newPassword);
    		return true;
    		
    	}return false;
    	
    }
   
    //checks the role of the user in order to display the according interface
    //all hr employees are admins and all admins come from hr department
   public boolean isAdmin(String userName) {
	   if(userRepository.getRole(userName).equals("admin")) {
		   return true;
	   }else {
		   return false;
	   
      }
   }
   
   
   
   public boolean signUp(User user) {
	   if(!validateUser(user)) {
		   return false;		      
	   }
	   userRepository.addUser(user);
	   return true;
   }
   
   private boolean validateUser(User user) {
	  return userRepository.getUserById(user.getId()) == null &&
			  employeeRepository.getByEmployeeId(user.getId()) != null;
	   
   }
   
   private boolean validateResetPass(User user) {
	   return userRepository.getSecurityQuestion(user.getUserName()).equals(user.getQuestion()) && userRepository.getSecurityAnswer(user.getUserName()).equals(user.getAnswer());
   		
   }
   
   public boolean resetPassword(User user) throws IOException {
	   if(!validateResetPass(user)) {
		   return false;
	   }
	   userRepository.updateUser(user);
	   return true;
   }
   
   
        
	
}
