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
//@WebFilter("/*")//WebFilter �ֳ����̼��� �̿��� ��� ��û�� ���͸� ��ġ�� ����
public class EncoderFilter implements Filter {
	ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {//doFilter()�ȿ��� ���� ���� ����� ����
		System.out.println("utf-8 ���ڵ�............");
		context = fConfig.getServletContext();

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("doFilter ȣ��");
		request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ� �۾��� ����
		String context = ((HttpServletRequest) request).getContextPath();//�� ���ø����̼��� ���ؽ�Ʈ �̸��� ������ �´�.
		String pathinfo = ((HttpServletRequest) request).getRequestURI();//�� ���������� ��û�� ��û URL�� ������ �´�.
		String realPath = request.getRealPath(pathinfo);//��û URL�� ���� ��θ� ������ �´�.
		String mesg = " Context  ����:" + context + "\n URI ���� : " + pathinfo + "\n ������ ���:  " + realPath;
		System.out.println(mesg);

		long begin = System.currentTimeMillis();//��û ���Ϳ��� ��û ó�� ���� �ð��� ���Ѵ�.
		
		/*�� ������ ��Ī ��� ����*/
		chain.doFilter(request, response);//���� ���ͷ� �ѱ�� �۾��� �����Ѵ�. 
		/*�� �ؿ��� ���� ���� ���*/
		long end = System.currentTimeMillis();//���� ���Ϳ��� ��û ó�� ���� �ð��� ���Ѵ�
		System.out.println("�۾� �ð�:" + (end - begin) + "ms");//�۾� ��û ���� ���� �ð� ���̸� ���� �۾� ���� �ð��� ���Ѵ�. 

	}

	/**
	 * 
	 * 
	 * /**
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy ȣ��");
	}

}
