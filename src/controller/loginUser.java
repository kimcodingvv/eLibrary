package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.userManagement;

@WebServlet("/loginUser")
public class loginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		userManagement um = new userManagement();
		
		if(um.login(id, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(15*60);
			out.println("<script>alert('로그인 되었습니다.'); location.href='.'; </script>");
		}
		else {
			out.println("<script>alert('아이디와 비밀번호를 확인해주세요.'); location.href='login'; </script>");
		}
	}

}
