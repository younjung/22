package model;

public class Customer {
	
	private String id;
	private String name;
	private String email; //�ʵ�
	private String password;
	private String gender;
	
	public Customer(String id, String name, String email, String password, String gender) { //bean
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
