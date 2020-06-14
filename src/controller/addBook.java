package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.bookManagement;

@WebServlet("/addBook")
public class addBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookManagement bm = new bookManagement();
		String id = request.getParameter("id").trim();
		String title = request.getParameter("title").trim();
		String author = request.getParameter("author").trim();
		String price = request.getParameter("price").trim();
		String action = null;
		RequestDispatcher rd = request.getRequestDispatcher("/view/layout.jsp");
		if(id.equals("") || title.equals("") || author.equals("") || price.equals(""))
			action = "insertResult/dataNull";
		else if(!bm.addBook(id, title, author, price)) action = "insertResult/existID";
		if(action != null) {
			request.setAttribute("action", action);
			rd.forward(request, response);
		}
		else response.sendRedirect("catalog");
	}

}
