package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	//doLogin과 doRegister에서도 접근해야 함, 싱글톤(singleton)
	//하나의 객체를 생성해서 공유
	
	private Map<String, Customer> customers; //key value
	
	private static final CustomerService instance = new CustomerService();
	//final 한번 초기화 하면 변경x
	//static 클래스에 하나의 변수
	//instance는 CustomerService 객체의 포인터

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance() {
		return instance;
	}
	//외부에서는 instance로 접근해야 함 getter
	//싱글톤
	
	public void addCustomer(Customer customer) { //맵에 Customer 추가
		customers.put(customer.getId(), customer); //key, value
	}
	
	public Customer findCustomer(String id) {
		if(id != null)
			return (customers.get(id.toLowerCase()));
		else
			return null;
	}
	
	public Customer login(String id, String password) {
		//DoLogin에서 받은 id와 password를 확인
		//맵에 존재하는지 확인
		if (customers.get(id.toLowerCase()).getPassword().equals(password))
			return customers.get(id);
		else
			return null;
	}
}
