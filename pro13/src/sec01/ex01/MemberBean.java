package sec01.ex01;

import java.sql.Date;

public class MemberBean {//중요: 회원 테이블의 이름과 동일하게 이름과 자료형을 선언해야 한다.
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	
	public MemberBean() {
		
	}


	public MemberBean(String id, String pwd, String name, String email) {//인자가 4개인 생성자를 추가한다.
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}


	/*--여기부터 밑에 끝까지 getter/setter 설정--*/
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
