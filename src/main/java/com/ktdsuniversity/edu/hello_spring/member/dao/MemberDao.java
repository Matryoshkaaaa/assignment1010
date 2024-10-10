package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

public interface MemberDao {
	
	// static final 생략가능
	public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao";
	
	
	public int getEmailCount(String email);
	
	public int insertNewMember(RegistMemberVO registMemberVO);

	public String selectSalt(String email);

	public MemberVO selectOneMember(LoginMemberVO loginMemberVO);
	
	public int updateLoginFailState(LoginMemberVO loginMemberVO); 
	
	public int selectLoginImpossibleCount(String email);
	
	public int updateLoginSuccessState(LoginMemberVO loginMemberVO);
	
	public int deleteMe(String email);
}
