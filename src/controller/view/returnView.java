package controller.view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.filterBookList;

@WebServlet("/returnView")
public class returnView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public returnView() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		filterBookList list = new filterBookList();
		request.setAttribute("bookList", list.getAll());
		RequestDispatcher ret = request.getRequestDispatcher("view/layout.jsp");
		ret.forward(request,response);
	}
}
