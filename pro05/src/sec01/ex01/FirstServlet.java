package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet  extends HttpServlet{ //HttpServlet 을 상속받음
   public void init() throws ServletException {
      System.out.println("init 메서드 호출");
   }

   // 브라우저의 요청을 처리함
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
      System.out.println("doGet 메서드 호출");
   } 

   //서블릿 기능을 수행하고 소멸될 때 호출됨
   public void destroy() {
      System.out.println("destroy 메서드 호출");
   }
}
