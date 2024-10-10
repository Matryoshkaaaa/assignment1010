package com.ktdsuniversity.edu.hello_spring.member.service;

import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

public interface MemberService {
	
	
	public boolean insertNewMember(RegistMemberVO registMemberVO);
	
	public boolean checkAvailableEmail(String email);
	
	// 파라미터를 줄테니깐 MemberVO를 내놔라
	public MemberVO readMember(LoginMemberVO loginMemberVO);
	
	public boolean deleteMe(String email);
}
