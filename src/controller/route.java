package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class route
 */
@WebServlet("/route")
public class route extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public route() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		request.setAttribute("action", action);
		RequestDispatcher ret = request.getRequestDispatcher((action.equals("home") ? "/view/layout.jsp" : action + "View"));
		ret.forward(request, response);
	}

}
