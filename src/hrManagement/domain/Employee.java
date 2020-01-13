package hrManagement.domain;

public class Employee {
	private String name;
	private String lastname;
	private String doh;
	private String id;
	private String email;
    private String address;
    private String phone;
    private String department;
    private String fulltime;
    private String manager;
    
	    
	public Employee(String id, String name, String lastname,
					String doh, String email, String address,
					String phone, String department,String fulltime,String manager) {
		
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.doh = doh;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.department = department;
		this.fulltime = fulltime;
		this.manager = manager;
	}


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDoh() {
		return doh;
	}

	public void setDoh(String doh) {
		this.doh = doh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    public void setFulltime(String fulltime) {
    	this.fulltime = fulltime;
    }
	public String getFulltime() {
		return fulltime;
	}
	public String checkIfFulltime() {
		return fulltime;
	}

	public String isManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public String checkIfManager() {
		return manager;
	}


	@Override
	public String toString() {
		return id + "," + name + "," + lastname + "," + doh + "," +  email
				+ "," + address + "," + phone + "," + department + "," + fulltime
				+ "," + manager;
	}
	
	
} 

	
	
	
	


