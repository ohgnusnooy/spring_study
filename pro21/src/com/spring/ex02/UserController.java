package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {//설정 파일의 userMethodNameResolver 프로퍼터를 사요앟려면 반드시 MultiActionController를 상속받아야 함
	/*public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		//ModelAndView에 로그인 정보를 바인딩함
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		
		mav.setViewName("result");//ModelAndView 객체에 포워딩할 JSP 이름을 설정함
		return mav;
	}*/
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();//getViewName()메서드르 ㄹ호출해 요청명에서 확장명 .do를제외한 뷰이름을 가지고옴
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		String viewName=getViewName(request);
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		mav.setViewName(viewName);//뷰이름지정
	    System.out.println("ViewName:"+viewName);
		return mav;
	}

	
	//코드 끝 까지 해당
	//request 객체에URL 요청명을 가져와.do를 제외한 요청명을 구함
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    //회원 가입창에서 전송된 회원 정부를 addObject()메서드를 이용해 ModelAndView 객체에 바인딩함
	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    
	    mav.setViewName("memberInfo");//member.jsp 로 포워딩함
	    return mav;
	}
	
	private  String getViewName(HttpServletRequest request) throws Exception {
	      String contextPath = request.getContextPath();
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	      if(uri == null || uri.trim().equals("")) {
	         uri = request.getRequestURI();
	      }
	      
	      //http://localhost:8090/member/listMember.do로 요청시
	      int begin = 0;  //
	      if(!((contextPath==null)||("".equals(contextPath)))){
	         begin = contextPath.length();  // 전체 요청명 의 길이를 구함
	      }

	      int end;
	      if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");  //요청 uri에 ';'가 있을 경우 ';'문자 위치를 구함
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");   //요청 uri에 '?'가 있을 경우 '?' 문자 위치를 구함
	      }else{
	         end=uri.length();
	      }

	      //http://localhost:8090/member/listMember.do로 요청시 먼저 '.do'를 제거한 http://localhost:8090/member/listMember를 구한 후,
	      //다시 http://localhost:8090/member/listMember에서 역순으로 첫번째 '/' 위치를 구한 후, 그 뒤의 listMember를 구한다.
	      String fileName=uri.substring(begin,end);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));  //요청명에서 역순으로 최초 '.'의 위치를 구한후, '.do' 앞에까지의 문자열을 구함
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length()); //요청명에서 역순으로 최초 '/'의 위치를 구한후, '/' 다음부터의 문자열을 구함  
	      }
	      return fileName;
	   }

	
	
}
