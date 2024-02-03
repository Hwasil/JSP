package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join") // 회원가입창
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO(); 					//SQL문으로 조회할 MemberDAO 객체 생성 
		PrintWriter out = response.getWriter();				//listMembers() 메서드로 회원 정보 조회
		String command = request.getParameter("command");	// command 값 받아옴
		String inputid = request.getParameter("id");

		if (command != null && command.equals("addMember")) {	// 회원 가입창에서 전송된 command가 addMember이면 전송된 값들을 받아옴
			String _id = request.getParameter("id");			// 전송된 값들을 얻어 와 MemberVO객체에 저장 후 SQL문을 통해 전달
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			String _address = request.getParameter("address");
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			vo.setAddress(_address);
			dao.addMember(vo);
			
		} 
		else if (command != null && command.equals("delMember")) { // command 값이 delMember인 경우 ID를 가져와 SQL문으로 전달해 삭제
			dao.delMember(inputid);
		} 
		
		if (inputid.equals("admin")) {
			List<MemberVO> list = dao.listMembers();
			out.print("<html><body>");
			out.print("<font size = '10'>관리자로 로그인</font>");
			out.print("<table border=1><tr align='center' bgcolor='PaleTurquoise'>");
			out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>주소</td><td>"
							+ "	가입일</td><td>삭제</td></tr>");
			
			// 조회한 회원 정보를 리스트로 출력
			for (int i=0; i < list.size(); i++) { 
				//MemberVO memberVO = (MemberVO) list.get(i);
				MemberVO memberVO = list.get(i);
				String id = memberVO.getId();
				String pwd = memberVO.getPwd();
				String name = memberVO.getName();
				String email = memberVO.getEmail();
				String address = memberVO.getAddress();
				String joinDate = memberVO.getJoinDate();
				out.print("<tr><td>" + id + "</td><td>" 
						+ pwd + "</td><td>" + name + "</td><td>" 
						+ email + "</td><td>"  + address + "</td><td>" + joinDate + "</td><td>"
						+ "<a href='/Project/join?command=delMember&id=" + id + "'> 삭제 </a></td></tr>"); 
							// 삭제를 클릭하면 command값과 회원 ID를 서블릿으로 전송
			}
			out.print("</table></body></html>");
			out.print("<a href='/Project/HomeBook.html'> 홈으로 </a>");
		} else {
			out.print("<html><body>");
			out.print(inputid + "님. 가입을 환영합니다!");
			out.print("</body></html><br>");
			out.print("<a href='/Project/memberForm.html'> 새 회원 등록하기 </a><br>"); 
			out.print("<a href='/Project/HomeBook.html'> 홈으로 </a>");
		}
		
	}
}
