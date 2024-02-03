package sec02.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDAO {	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public BookDAO() {
		try {
			// JNDI에 접근하기 위해 기본 경로 설정
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			// 미리 연결한 DataSource 받아옴
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BookVO> listMembers() {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			con = dataFactory.getConnection();			// DataSource를 이용해 데베에 연결
			
			String query = "select * from tbook";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);		// prepareStatement() 메서드에 SQL문을 전달해 prepareStatement 객체 생성
			ResultSet rs = pstmt.executeQuery(query);	// excuteQuery() 메서드를 호출해 미리 설정한 SQL문 실행
			
			while (rs.next()) {
				String bid = rs.getString("bookid");
				String bname = rs.getString("bookname");
				String pub = rs.getString("publisher");
				String price = rs.getString("price");
				BookVO vo = new BookVO();
				vo.setBookid(bid);
				vo.setBookname(bname);
				vo.setPublisher(pub);
				vo.setPrice(price);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	 
	public void addMember (BookVO memberVO) {
		try {
			con = dataFactory.getConnection();			// DataSource를 이용해 데베에 연결
			String bid = memberVO.getBookid();				// 테이블에 저장할 회원 정보 받아옴
			String bname = memberVO.getBookname();
			String pub = memberVO.getPublisher();
			String price = memberVO.getPrice();		
			
			String query = "insert into tbook";		// insert문을 문자열로 만듦
			query += " (bid,bname,pub,price)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bid);			// insert문의 각 '?' 순서대로 회원 정보 세팅
			pstmt.setString(2, bname);
			pstmt.setString(3, pub);
			pstmt.setString(4, price);
			pstmt.executeUpdate();			// 회원 정보를 테이블에 추가
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember (String id) {
		try {
			con = dataFactory.getConnection();	// DataSource를 이용해 데베에 연결
			
			String query = "delete from tbook" + " where id=?";	// delete문을 문자열로 만듦
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);		// 첫 번째 '?'에 전달된 ID를 인자로 넣음
			pstmt.executeUpdate();		// delete문을 실행해 테이블에서 해당 ID의 회원 정보를 삭제
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
