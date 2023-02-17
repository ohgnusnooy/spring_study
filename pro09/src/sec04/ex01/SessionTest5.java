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
 * Servlet implementation class SessionTest5
 */
//@WebServlet("/login")
public class SessionTest5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");//�α��� â���� ���۵� ID�� ��й�ȣ�� �������
		String user_pw = request.getParameter("user_pw");//
		
		if (session.isNew()){//���� ��û�� ����
			if(user_id != null){//�α���â���� �������� ��û�ߴٸ� ID�� null�� �ƴϹǷ� ���ǿ� ID�� ���ε��Ѵ�.
				session.setAttribute("user_id", user_id);
				String url=response.encodeURL("login");//���� url�� encodeURL()�� �̿��� ���� �� �̸� ������ ������
				out.println("<a href="+url+">�α��� ���� Ȯ��</a>");//�α��� ���� Ȯ�� Ŭ�� �� ������ �������� �ٽ� ������
			}else {
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		}else{//���û�� ���ǿ��� ID�� ������ ������ �α��� �ߴ��� ���θ� Ȯ���Ѵ�.
			user_id = (String) session.getAttribute("user_id");
			if (user_id != null && user_id.length() != 0) {
				out.print("�ȳ��ϼ��� " + user_id + "��!!!");
			} else {
				out.print("<a href='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		}
	}

}
