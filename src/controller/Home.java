package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //action 에는 login, help 값이 저장
		
		String page = null;
		
		if (action.equals("login"))
			page = "/view/loginform.jsp";
		
		else if (action.equals("register"))
			page="/view/registerform.jsp";
		
		else
			page="/view/error.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); //해당하는 page로 포워딩 시키는
		dispatcher.forward(request, response);
		
		
	}

}
