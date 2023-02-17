package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener//�ֳ����̼����� �����ʰ� ��ϵ�.
//HttpSessonBindingListner�� ������ Listner�� ������ ��� �̺�Ʈ �ڵ鷯�� �ݵ�� �ֳ����̼��� �̿��ؼ� Listner�� ����ؾ���
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
	public void sessionCreated(HttpSessionEvent arg0) {//���� ���� �� �̺�Ʈ�� ó����
		System.out.println("���� ����");
		++total_user;//���� ���� �� ������ ���� 1������Ŵ
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {//���� �Ҹ�� �̺�Ʈ�� ó����
		System.out.println("���� �Ҹ�");
		--total_user;//���� �Ҹ�� ������ ���� 1���ҽ�Ŵ
	}

}
