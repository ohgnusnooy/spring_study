package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest
 */
//@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding( "utf-8" );//post방식으로 한글 전송시 인코딩 작업을 생략하기 때문에 주석 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		out.println("<html><body>");
		out.println("이름는 " + user_name + "<br>");
		out.println("비밀번호는 " + user_pw + "<br>");
		out.println("</body></html>");

	}

}
