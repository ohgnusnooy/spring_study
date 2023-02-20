package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {//���� ������ userMethodNameResolver �������͸� ���۷��� �ݵ�� MultiActionController�� ��ӹ޾ƾ� ��
	/*public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		//ModelAndView�� �α��� ������ ���ε���
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		
		mav.setViewName("result");//ModelAndView ��ü�� �������� JSP �̸��� ������
		return mav;
	}*/
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();//getViewName()�޼��帣 ��ȣ���� ��û���� Ȯ��� .do�������� ���̸��� �������
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		String viewName=getViewName(request);
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		mav.setViewName(viewName);//���̸�����
	    System.out.println("ViewName:"+viewName);
		return mav;
	}

	
	//�ڵ� �� ���� �ش�
	//request ��ü��URL ��û���� ������.do�� ������ ��û���� ����
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    //ȸ�� ����â���� ���۵� ȸ�� ���θ� addObject()�޼��带 �̿��� ModelAndView ��ü�� ���ε���
	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    
	    mav.setViewName("memberInfo");//member.jsp �� ��������
	    return mav;
	}
	
	private  String getViewName(HttpServletRequest request) throws Exception {
	      String contextPath = request.getContextPath();
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	      if(uri == null || uri.trim().equals("")) {
	         uri = request.getRequestURI();
	      }
	      
	      //http://localhost:8090/member/listMember.do�� ��û��
	      int begin = 0;  //
	      if(!((contextPath==null)||("".equals(contextPath)))){
	         begin = contextPath.length();  // ��ü ��û�� �� ���̸� ����
	      }

	      int end;
	      if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");  //��û uri�� ';'�� ���� ��� ';'���� ��ġ�� ����
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");   //��û uri�� '?'�� ���� ��� '?' ���� ��ġ�� ����
	      }else{
	         end=uri.length();
	      }

	      //http://localhost:8090/member/listMember.do�� ��û�� ���� '.do'�� ������ http://localhost:8090/member/listMember�� ���� ��,
	      //�ٽ� http://localhost:8090/member/listMember���� �������� ù��° '/' ��ġ�� ���� ��, �� ���� listMember�� ���Ѵ�.
	      String fileName=uri.substring(begin,end);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));  //��û���� �������� ���� '.'�� ��ġ�� ������, '.do' �տ������� ���ڿ��� ����
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length()); //��û���� �������� ���� '/'�� ��ġ�� ������, '/' ���������� ���ڿ��� ����  
	      }
	      return fileName;
	   }

	
	
}
