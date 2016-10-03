package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {
	//doLogin�� doRegister������ �����ؾ� ��, �̱���(singleton)
	//�ϳ��� ��ü�� �����ؼ� ����
	
	private Map<String, Customer> customers; //key value
	
	private static final CustomerService instance = new CustomerService();
	//final �ѹ� �ʱ�ȭ �ϸ� ����x
	//static Ŭ������ �ϳ��� ����
	//instance�� CustomerService ��ü�� ������

	private CustomerService() {
		customers = new HashMap<String, Customer>();
	}
	
	public static CustomerService getInstance() {
		return instance;
	}
	//�ܺο����� instance�� �����ؾ� �� getter
	//�̱���
	
	public void addCustomer(Customer customer) { //�ʿ� Customer �߰�
		customers.put(customer.getId(), customer); //key, value
	}
	
	public Customer findCustomer(String id) {
		if(id != null)
			return (customers.get(id.toLowerCase()));
		else
			return null;
	}
	
	public Customer login(String id, String password) {
		//DoLogin���� ���� id�� password�� Ȯ��
		//�ʿ� �����ϴ��� Ȯ��
		if (customers.get(id.toLowerCase()).getPassword().equals(password))
			return customers.get(id);
		else
			return null;
	}
}
