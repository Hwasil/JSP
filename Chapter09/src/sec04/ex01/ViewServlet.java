package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		List membersList = (List) request.getAttribute("membersList");
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='PaleTurquoise'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (int i=0; i < membersList.size(); i++) {
			MemberVO memberVO = (MemberVO) membersList.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" 
					+ pwd + "</td><td>" + name + "</td><td>" 
					+ email + "</td><td>"  + joinDate + "</td><td>"
					+ "<a href='/Chapter08/Member8?command=delMember&id=" + id + "'> 삭제 </a></td></tr>");
		}
		out.print("</table></body></html>");
		out.print("<a href='/Chapter08/memberForm2.html'> 새 회원 등록하기 </a>");
		
	}

}
