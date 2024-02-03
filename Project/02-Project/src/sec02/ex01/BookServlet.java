package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book") 
public class BookServlet extends HttpServlet {
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
		BookDAO dao = new BookDAO(); 					//SQL문으로 조회할 MemberDAO 객체 생성 
		PrintWriter out = response.getWriter();				//listMembers() 메서드로 회원 정보 조회
		String command = request.getParameter("command");	// command 값 받아옴
				
		if (command != null && command.equals("addMember")) {	// 회원 가입창에서 전송된 command가 addMember이면 전송된 값들을 받아옴
			String _bid = request.getParameter("bid");			// 전송된 값들을 얻어 와 MemberVO객체에 저장 후 SQL문을 통해 전달
			String _bname = request.getParameter("bname");
			String _pub = request.getParameter("pub");
			String _price = request.getParameter("price");
			BookVO vo = new BookVO();
			vo.setBookid(_bid);
			vo.setBookname(_bname);
			vo.setPublisher(_pub);
			vo.setPrice(_price);
			dao.addMember(vo);
			
		} else if (command != null && command.equals("delMember")) { // command 값이 delMember인 경우 ID를 가져와 SQL문으로 전달해 삭제
			String bid = request.getParameter("bid");
			dao.delMember(bid);
		} 
		
		List<BookVO> list = dao.listMembers();
		out.print("<html><body>");
		out.print("<font size = '10'>도서 목록</font>");
		out.print("<table border=1><tr align='center' bgcolor='PaleTurquoise'>");
		out.print("<td>도서 번호</td><td>도서 제목</td><td>출판사</td><td>가격</td></tr>");
		
		// 조회한 회원 정보를 리스트로 출력
		for (int i=0; i < list.size(); i++) { 
			//MemberVO memberVO = (MemberVO) list.get(i);
			BookVO BookVO = list.get(i);
			String bid = BookVO.getBookid();
			String bname = BookVO.getBookname();
			String pub = BookVO.getPublisher();
			String price = BookVO.getPrice();
			out.print("<tr><td>" + bid + "</td><td>" + bname + "</td><td>" 
					+ pub + "</td><td>"  + price + "</td></tr>"); 
		}
		out.print("</table></body></html>"); 
		out.print("<a href='/Project/HomeBook.html'> 홈으로 </a>");		
	}
}
