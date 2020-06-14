package controller.view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.filterBookList;

@WebServlet("/searchView")
public class searchView extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public searchView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		filterBookList list = new filterBookList();
		String column = request.getParameter("column");
		String value = request.getParameter("value");
		if(column == null)
			request.setAttribute("bookList", list.getAll());
		else
			request.setAttribute("bookList", list.getSearch(column, value));
		RequestDispatcher rd = request.getRequestDispatcher("view/layout.jsp");
		rd.forward(request, response);
	}

}
