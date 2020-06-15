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

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		userManagement um = new userManagement();
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		int result = um.deleteUser(id, pw);
		if(result == 1) {
			session.invalidate();
			out.println("<script>alert('탈퇴가 되었습니다.'); location.href='.';</script>");
		}
		else if(result == 0){
			out.println("<script>alert('비밀번호를 틀렸습니다.'); location.href='myInfo';</script>");
		}
		else {
			out.println("<script>alert('책을 먼저 반납해주세요.'); location.href='return';</script>");	
		}
	}
}
