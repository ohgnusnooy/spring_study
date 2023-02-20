package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;


public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {//���� ���Ͽ��� ������ dataSource ���� setter�� �̿��� jdbcTemplate Ŭ���� �������� ���ڷ� ����
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<?> selectAllMembers() throws DataAccessException {
		String query = "select id,pwd,name,email,joinDate" + " from t_member " + " order by joinDate desc";
		List<?> membersList = new ArrayList<Object>();

		//jdbcTemplate Ŭ������ query() �޼��� ���ڷ� select���� ������ ��ȸ�� ���ڵ��� ������ŭ MemberVO ��ü�� ����
		//�����ڵ��� ���� �Ӽ��� �����ϰ� �ٽ� memberList�� ����
		membersList = this.jdbcTemplate.query(query, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				return memberVO;
			}
		});
		return membersList;
	}

	
	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		String query = "insert into t_member(id,pwd, name,email) values  ("
		                 + "'" + id + "' ,"
	 	                 + "'" + pwd + "' ,"
		                 + "'" + name + "' ,"
		                 + "'" + email + "') ";
		System.out.println(query);
		int result = jdbcTemplate.update(query);//jdbcTemplate Ŭ������ update() �޼���� ȸ�� ������ �߰�
		System.out.println(result);
		return result;
	}

}
