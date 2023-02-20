package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();//member.xml�� SQL���� ȣ���ϴµ� ���Ǵ� sqlSession�� �ҷ���
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");//���� ���� ���ڵ带 ��ȸ�ϹǷ� selectList() �޼��忡 �����ϰ��� �ϴ� SQL���� id�� ���ڷ� ����
		return memlist;
	}
	
	
}
