package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.userManagement;

@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		userManagement um = new userManagement();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String confirmPw = request.getParameter("confirmPw");
		
		PrintWriter out = response.getWriter();
		int result = um.addUser(id, password, confirmPw);
		
		if(result == 1) {
			out.println("<script> alert('가입이 되었습니다.'); location.href='.'; </script>");
		}
		else if(result == 0) {
			out.println("<script> alert('아이디 중복입니다.'); location.href='signup'; </script>");
		}
		else {
			out.println("<script> alert('입력한 두 비밀번호가 다릅니다.'); location.href='signup'; </script>");
		}
	}

}
