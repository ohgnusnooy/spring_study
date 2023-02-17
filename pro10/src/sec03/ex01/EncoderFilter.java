package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
//@WebFilter("/*")//WebFilter 애너테이션을 이용해 모든 요청이 필터를 거치게 만듬
public class EncoderFilter implements Filter {
	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {//doFilter()안에서 실제 필터 기능을 구현
		System.out.println("utf-8 인코딩............");
		context = fConfig.getServletContext();

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");//한글 인코딩 작업을 시행
		String context = ((HttpServletRequest) request).getContextPath();//웹 애플리케이션의 컨텍스트 이름을 가지고 온다.
		String pathinfo = ((HttpServletRequest) request).getRequestURI();//웹 브라우저에서 요청한 요청 URL을 가지고 온다.
		String realPath = request.getRealPath(pathinfo);//요청 URL의 실제 경로를 가지고 온다.
		String mesg = " Context  정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로:  " + realPath;
		System.out.println(mesg);

		long begin = System.currentTimeMillis();//요청 필터에서 요청 처리 전의 시각을 구한다.
		
		/*이 위에는 요칭 기능 필터*/
		chain.doFilter(request, response);//다음 필터로 넘기는 작업을 수행한다. 
		/*이 밑에는 응답 필터 기능*/
		long end = System.currentTimeMillis();//응답 필터에서 요청 처리 후의 시각을 구한다
		System.out.println("작업 시간:" + (end - begin) + "ms");//작업 요청 전과 후의 시각 차이를 구해 작업 수행 시간을 구한다. 

	}

	/**
	 * 
	 * 
	 * /**
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 호출");
	}

}
