package sec05.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {	
	protected  void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,  IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      ServletContext context = getServletContext();//Servletcontext 객체를 가지고 온다

      //web.xml의 <paran-name>태그의 이름으로 <param-value>태그의 값인 메뉴 이름들을 받아 온다.
      String menu_member = context.getInitParameter("menu_member");
      String menu_order = context.getInitParameter("menu_order");
      String menu_goods =context.getInitParameter("menu_goods");

      out.print("<html><body>");
      out.print("<table border=1 cellspacing=0><tr>메뉴 이름</tr>");
      out.print("<tr><td>" + menu_member + "</td></tr>");
      out.print("<tr><td>" + menu_order + "</td></tr>");
      out.print("<tr><td>" + menu_goods + "</td></tr>");
      out.print("</tr></table></body></html>");	
   }
}
