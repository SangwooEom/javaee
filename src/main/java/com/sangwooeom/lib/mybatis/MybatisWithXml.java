package com.sangwooeom.lib.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sangwooeom.lib.mybatis.mapper.MemberMapper;
import com.sangwooeom.lib.mybatis.model.Member;

public class MybatisWithXml {
	public static void main(String[] args) throws IOException {
		String resource = "com/sangwooeom/lib/mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// openSession을 통해서 얻은 SqlSession은 자동으로 commit이 되지 않기 때문에 수동으로 commit을 해야 한다.
		try (SqlSession session = sqlSessionFactory.openSession()) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			
			Member member = new Member();
			member.setId("hong");
			member.setPassword("1234");
			member.setName("홍길동");
			member.setEmail("hong@test.com");
			
			mapper.insert(member);
			
			session.commit();
			
			List<Member> memberList = mapper.selectAll();
			
			for (Member memberOne: memberList) {
				System.out.println("seq: " + memberOne.getSeq());
				System.out.println("id: " + memberOne.getId());
				System.out.println("password: " + memberOne.getPassword());
				System.out.println("name: " + memberOne.getName());
				System.out.println("email: " + memberOne.getEmail());
				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
