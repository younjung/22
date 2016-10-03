package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		// DB�� ��ȸ�ؼ� ����� ���ڵ带 ��ȸ
		// Perform business logic. Return a bean as a result
		CustomerService service = new CustomerService(); //���� ��ü ����
		Customer customer = service.findCustomer(customerId); //���� ��ü�� find�Լ�, �Ķ���ͷ� ������ id�� customer�� �Ѱ� �ش�. bean
		request.setAttribute("customer", customer); //key���� ����, success���� Ȱ��
		
		// We can iterate over lists using forEach in JSTL
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("id006", "kim", "kim.hansung.ac.kr"));
		customers.add(new Customer("id007", "lee", "lee.hansung.ac.kr"));
		customers.add(new Customer("id008", "park", "park.hansung.ac.kr"));
		request.setAttribute("customerList", customers);
		
		
		
		String page;
		
		if(customer == null)
			page="/view/error.jsp";
		else
			page="/view/success.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); //�ش��ϴ� page�� ������ ��Ű��
		dispatcher.forward(request, response);
		
	}
	*/

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		CustomerService service = (CustomerService) CustomerService.getInstance();
		Customer customer = service.login(id, password);
		
		String page;
		
		if(customer == null) {
			page ="/view/loginFail.jsp";
			request.setAttribute("id", id);
		}
		else {
			page ="view/loginSuccess.jsp";
			request.setAttribute("customer", customer);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); //�ش��ϴ� page�� ������ ��Ű��
		dispatcher.forward(request, response);
		
		
		
	}

}
