package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.userManagement;

@WebServlet("/changePw")
public class changePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public changePw() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		userManagement um = new userManagement();
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String newPw = request.getParameter("newPw");
		String confirmNewPw = request.getParameter("confirmNewPw");
		String msg = "변경 되었습니다.";
		int result = um.changePw(id, pw, newPw, confirmNewPw);
		
		if(result == 2) msg = "입력한 새 비밀번호를 확인해주세요.";
		else if(result == 0) msg = "입력한 현재 비밀번호가 다릅니다.";
		out.println("<script>alert('" + msg + "'); location.href='myInfo'; </script>");
	}
}
