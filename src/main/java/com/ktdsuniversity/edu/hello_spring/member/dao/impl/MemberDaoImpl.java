package com.ktdsuniversity.edu.hello_spring.member.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sessionTemplate) {
		super.setSqlSessionTemplate(sessionTemplate);
	}

	@Override
	public int getEmailCount(String email) {

		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.getEmailCount",
				email);
	}

	@Override
	public int insertNewMember(RegistMemberVO registMemberVO) {

		return this.getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.insertNewMember",
				registMemberVO);
	}

	@Override
	public String selectSalt(String email) {
		return getSqlSession().selectOne(NAMESPACE + ".selectSalt", email);
	}

	@Override
	public MemberVO selectOneMember(LoginMemberVO loginMemberVO) {
		return getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginMemberVO);
	}
	
	@Override
	public int updateLoginFailState(LoginMemberVO loginMemberVO) {
		return getSqlSession().update(NAMESPACE + ".updateLoginFailState",loginMemberVO);
	}
	
	@Override
	public int selectLoginImpossibleCount(String email) {
		return getSqlSession().selectOne( NAMESPACE + ".selectLoginImpossibleCount",email);
	}

	@Override
	public int updateLoginSuccessState(LoginMemberVO loginMemberVO) {
		return getSqlSession().update(NAMESPACE + ".updateLoginSuccessState",loginMemberVO);
	}

	@Override
	public int deleteMe(String email) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteMe",email);
	}
	
	
}
