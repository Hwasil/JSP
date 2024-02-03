package ex202195027;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Clac")
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 메서드 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 메서드 호출");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle 메서드 호출");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String op = request.getParameter("op"); 
		String result;
		
		switch (op) {
		case "sum" :
			result = num1 + num2;
			break;
		case "min" :
			result = num1 - num2;
			break;
		case "mul" :
			result = num1 * num2;
			break;
		case "div" :
			result = num1 / num2;
			break;
		}
		
		out.println("<html><body>");
		out.println(num1 + op + num2 + "=" + result);
		out.println("</body></html>");
		
		response.addHeader("Refresh", "3;url=result");
	}
	
	/*
	 * private static int calculater (int num1, int num2, String op) { num1 =
	 * Integer.parseInt(num1); num2 = Integer.parseInt(num2); int result = 0;
	 * 
	 * switch (op) { case "sum" : result = num1 + num2; break; case "min" : result =
	 * num1 - num2; break; case "mul" : result = num1 * num2; break; case "div" :
	 * result = num1 / num2; break; } return result;
	 * 
	 * }
	 */

}
