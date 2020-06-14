package controller.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.filterBookList;

/**
 * Servlet implementation class catalogView
 */
@WebServlet("/catalogView")
public class catalogView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public catalogView() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		filterBookList list = new filterBookList();
		request.setAttribute("title", "목록");
		request.setAttribute("bookList", list.getAll());
		RequestDispatcher ret = request.getRequestDispatcher("view/layout.jsp");
		ret.forward(request,response);
	}

}
