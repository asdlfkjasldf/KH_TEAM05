package com.indimoa.member.model.service;

import static com.indimoa.common.JdbcTemplate.*;


import java.sql.Connection;

import com.indimoa.common.JdbcTemplate;
import com.indimoa.member.model.dao.MemberDao;
import com.indimoa.member.model.vo.Member;



public class MemberService { 

	public MemberService() {} 
// 로그인 시 Member 객체를 받아오는 메소드 
 
	public Member loginMember(String id, String passwd) { 
		Connection conn = JdbcTemplate.getConnection(); 
		Member m = new MemberDao().loginMember(conn, id, passwd);
		JdbcTemplate.close(conn);
		return m; 
	} 
// ID 중복 체크를 위한 메소드 
	public int dupIdChk(String id) { 
		Connection conn = JdbcTemplate.getConnection(); 
		int result = new MemberDao().dupIdChk(conn, id);
		JdbcTemplate.close(conn);
		return result; 
	} 
	// Member 객체를 추가하는 메소드 
	public int enrollMember(Member m) { 
		Connection conn = JdbcTemplate.getConnection(); 
		int result = new MemberDao().enrollMember(conn, m); 
 
		if(result > 0) commit(conn); 
		else rollback(conn);
		JdbcTemplate.close(conn); 
		 return result; 
		} 
		// 기존 Member 객체의 정보를 수정하는 메소드 
		 public int updateMember(Member m) { 
		 Connection conn = JdbcTemplate.getConnection(); 
		 int result = new MemberDao().updateMember(conn, m); 
		 
		 if(result > 0) commit(conn); 
		 else rollback(conn); 
		 JdbcTemplate.close(conn); 
		 
		 return result; 
		 } 
		// 멤버 객체의 삭제를 요청하는 메소드 
		 public int deleteMember(String id) { 
		 Connection conn = JdbcTemplate.getConnection(); 
		 int result = new MemberDao().deleteMember(conn, id); 
		 
		 if(result > 0) commit(conn); 
		 else rollback(conn); 
		 JdbcTemplate.close(conn); 
		 
		 return result; 
		 } 
		 
		 //멤버 아이디 찾기를 요청하는 메소드
		 public int selectId(String name, String email) {
				Connection conn = JdbcTemplate.getConnection();
				int userId = new MemberDao().selectId(conn, name, email);

				JdbcTemplate.close(conn);
				return userId;
		}
		 
		//멤버 비밀번호 찾기를 요청하는 메소드
		 public int selectPwd(String name, String id) {
				Connection conn = JdbcTemplate.getConnection();
				int userPwd = new MemberDao().selectId(conn, name, id);

				JdbcTemplate.close(conn);
				return userPwd;
		}
		
		 
		 
	} 

