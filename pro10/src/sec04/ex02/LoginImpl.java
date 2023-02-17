package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener//애너테이션으로 리스너가 등록됨.
//HttpSessonBindingListner를 제외한 Listner를 구현한 모든 이벤트 핸들러는 반드시 애너테이션을 이용해서 Listner로 등록해야함
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
	}

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {//세션 생성 시 이벤트를 처리함
		System.out.println("세션 생성");
		++total_user;//세션 생성 시 접속자 수를 1증가시킴
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {//세션 소멸시 이벤트를 처리함
		System.out.println("세션 소멸");
		--total_user;//세션 소멸시 접속자 수를 1감소시킴
	}

}
