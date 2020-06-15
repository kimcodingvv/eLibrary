package myfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class linkFilter
 */
@WebFilter("/linkFilter")

public class linkFilter implements Filter {

	public linkFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 req.setCharacterEncoding("utf-8");
		 String url[] = req.getRequestURI().toString().trim().split("/");
		String action = url[url.length - 1];
		if (excludeUrl(action)) {
			chain.doFilter(req, response);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("route?action=" + action);
           rd.forward(req, response);
		}
	}

	private boolean excludeUrl(String action) {
		if (action.equals("catalog") || action.equals("rentCntDesc")
				|| action.equals("yesRent") || action.equals("noRent")
				|| action.equals("rental") || action.equals("return") 
				|| action.equals("insert") || action.equals("delete") || action.equals("search")
				|| action.equals("signup") || action.equals("login")) {
			return false;
		} else {
			return true;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
