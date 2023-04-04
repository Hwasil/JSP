package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class initParamServlet
 */
@WebServlet(
		urlPatterns = { 
				"/sinit", 
				"/sinit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "js02@naver.com"), 
				@WebInitParam(name = "tel", value = "010-2001-1122")
		})
public class initParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 설정한 매개변수의 name으로 값을 가져옴
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.print("<html><body>");
		out.print("<tale><tr>");
		out.print("<td>email: </td><td>" + email + "</td></tr>");
		out.print("<td>휴대전화: </td><td>" + tel + "</td></tr>");
		out.print("</tr></table></body></html>");
		out.close();
	}

}
