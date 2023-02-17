package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
//@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();//URL���� ��û���� �������
		System.out.println("action:" + action);
		if (action == null || action.equals("/listMembers.do")) {//���� ��û�̰ų� action���� /memberList.do�̸� ȸ�� ����� ���
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";//test02 ������ listMember.jsp�� ������
		} else if (action.equals("/addMember.do")) {//action���� /addMember.do�� ���۵� ȸ�� ������ ������ �ͼ� ���̺� �߰�
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/listMembers.do";//ȸ�� ��� �� �ٽ� ȸ�� ����� ���

		} else if (action.equals("/memberForm.do")) {//action ���� /memberForm.do�� ȸ�� ����â�� ȭ�鿡 ���
			nextPage = "/test02/memberForm.jsp";//test02 ������ memberForm.jsp�� ��������
		} else {//�� �� �ٸ� action ���� ȸ�� ����� �����
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
		}
		
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);//nextPage�� ������ ��û������ �ٽ� ������ ��û
		dispatch.forward(request, response);
	}

}