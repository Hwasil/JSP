package Ch6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest
 */
@WebServlet("/LoginTest2")
public class LoginTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		
		if (id != null && (id.length() != 0)) {
			if ( id.equals("admin")) {
				out.print("<html>");
				out.print("<body>");
				out.print("<font size='12'> 관리자로 로그인 하셨습니다! </font>");
				out.print("</body>"); 
				out.print("</html>");
			} else {
				out.print("<html>");
				out.print("<body>");
				out.print(id + "님이 로그인 하셨습니다.");
				out.print("</body>"); 
				out.print("</html>");
			}	 
		} else {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디와 비밀번호를 입력하세요!");
			out.print("<br>");
			out.print("<a href='http://localhost:8070/Report/login.html'> 로그인 창으로 이동 </a>");
			out.print("</body>"); 
			out.print("</html>"); 
		}
	}

}
