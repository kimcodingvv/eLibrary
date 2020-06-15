package myfilter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/loginFilter")
public class loginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		
		if(id == null) {
			out.println("<script>alert('로그인을 먼저 해주세요.'); location.href='login'; </script>");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
