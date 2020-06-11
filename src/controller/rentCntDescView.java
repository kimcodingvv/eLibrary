package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.filterBookList;

@WebServlet("/rentCntDescView")
public class rentCntDescView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public rentCntDescView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		filterBookList list = new filterBookList();
		request.setAttribute("action", "catalog");
		request.setAttribute("bookList", list.getRentalCntDesc());
		RequestDispatcher ret = request.getRequestDispatcher("view/layout.jsp");
		ret.forward(request,response);
	}
}
