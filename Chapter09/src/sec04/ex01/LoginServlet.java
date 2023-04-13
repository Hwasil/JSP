package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login4")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 로그인 창에서 전송된 아이디와 비밀번호를 가지고 옴
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		// memberVO 객체 생성하고, 속성으로 아이디와 비밀번호를 설정
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		
		// MemberDAO 객체를 생성
		MemberDAO dao = new MemberDAO();
		
		// memberVO의 isExisted() 메서드를 호출하여 memberVO를 인자로 전달
		boolean result = dao.isExisted(memberVO);
		
		if (result) { // 조회한 결과가 true이면
			HttpSession session = request.getSession();
			
			// isLogin 속성을 true로 세션에 저장
			session.setAttribute("isLogin", true);
			// 아이디와 비밃번호를 세션에 저장
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			
			out.print("<html><body>");
			out.println("안녕하세요 " + user_id + "님!!!<br>");
			out.print("<a href='show'>회원정보보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body> 회원 아이디가 틀립니다.");
			out.print("<a href='login4.html'> 다시 로그인 하기</a>");
			out.print("</body></html>");
		}
	}
}
