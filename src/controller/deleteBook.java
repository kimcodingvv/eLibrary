package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.bookManagement;

@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookManagement bm = new bookManagement();
		String msg = null;
		boolean success = false;
		if(bm.deleteBook(request.getParameter("id"))) {
			msg = "삭제되었습니다.";
			success = true;
		}
		else msg = "존재하지 않는 아이디입니다.";

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + msg + "');");
		if(success) out.println("location.href='delete';"); 
		else out.println("history.back();");
		out.println("</script>");
	}
}
