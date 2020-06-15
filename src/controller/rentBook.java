package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.bookManagement;

@WebServlet("/rentBook")
public class rentBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rentBook() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		bookManagement bm = new bookManagement();
		String action;
		String id = request.getParameter("rentalID");
		String user = request.getParameter("rentUser");
		if(bm.rentBook(id,user))
			action = "rentResult/success";
		else action = "rentResult/fail";
		request.setAttribute("action", action);
		RequestDispatcher ret = request.getRequestDispatcher("view/layout.jsp");
		ret.forward(request, response);
	}
}
