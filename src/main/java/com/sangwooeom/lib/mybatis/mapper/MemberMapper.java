package com.sangwooeom.lib.mybatis.mapper;

import java.util.List;

import com.sangwooeom.lib.mybatis.model.Member;

public interface MemberMapper {
	public List<Member> selectAll();
	
	public Member selectBySeq(int seq);
	
	public int insert(Member member);
	
	public int update(Member member);
	
	public int delete(int set);
}
