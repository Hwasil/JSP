package sec01.ex01;

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

public class MemberDAO {	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
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
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			con = dataFactory.getConnection();			// DataSource를 이용해 데베에 연결
			
			String query = "select * from tmember";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);		// prepareStatement() 메서드에 SQL문을 전달해 prepareStatement 객체 생성
			ResultSet rs = pstmt.executeQuery(query);	// excuteQuery() 메서드를 호출해 미리 설정한 SQL문 실행
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String joinDate = rs.getString("joindate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setAddress(address);
				vo.setJoinDate(joinDate);
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
	 
	public void addMember (MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();			// DataSource를 이용해 데베에 연결
			String id = memberVO.getId();				// 테이블에 저장할 회원 정보 받아옴
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String address = memberVO.getAddress();		
			
			String query = "insert into tmember";		// insert문을 문자열로 만듦
			query += " (id,pwd,name,email,address)";
			query += " values(?,?,?,?,?)";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);			// insert문의 각 '?' 순서대로 회원 정보 세팅
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, address);
			pstmt.executeUpdate();			// 회원 정보를 테이블에 추가
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember (String id) {
		try {
			con = dataFactory.getConnection();	// DataSource를 이용해 데베에 연결
			
			String query = "delete from tmember" + " where id=?";	// delete문을 문자열로 만듦
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
