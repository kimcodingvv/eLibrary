package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.bookManagement;

@WebServlet("/returnBook")
public class returnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public returnBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookManagement bm = new bookManagement();
		bm.returnBook(request.getParameter("id"));
		response.sendRedirect("catalog");
	}
}
