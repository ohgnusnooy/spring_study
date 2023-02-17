package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {//HttpSessionBindingListner�� ������ ���ǿ� ���ε� �� �̺�Ʈ�� ó���Ѵ�
	String user_id;
	String user_pw;
	static int total_user = 0;//���ǿ� ���ε� �� 1�� ������Ų��.

	public LoginImpl() {
	}

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {//���ǿ� ���� �� �����ڼ��� ������Ų��
		System.out.println("����� ����");
		++total_user;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {//���ǿ��� �Ҹ� �� ������ ���� ���ҽ�Ų��.
		System.out.println("����� ���� ����");
		total_user--;
	}
}
