package com.indimoa.board.member.model.service;


import static com.indimoa.board.comm.JDBCTemplate.*;
import java.sql.Connection;

import com.indimoa.board.member.model.vo.Member;
import com.indimoa.board.model.dao.MemberDao;

public class MemberService { 

	public MemberService() {} 
// 로그인 시 Member 객체를 받아오는 메소드 
 
	public Member loginMember(String id, String passwd) { 
		Connection conn = getConnection(); 
		Member m = new MemberDao().loginMember(conn, id, passwd);
		close(conn);
		return m; 
	} 
// ID 중복 체크를 위한 메소드 
	public int dupIdChk(String id) { 
		Connection conn = getConnection(); 
		int result = new MemberDao().dupIdChk(conn, id); 
		return result; 
	} 
	// Member 객체를 추가하는 메소드 
	public int insertMember(Member m) { 
		Connection conn = getConnection(); 
		int result = new MemberDao().insertMember(conn, m); 
 
		if(result > 0) commit(conn); 
		else rollback(conn);
		 close(conn); 
		 return result; 
		} 
		// 기존 Member 객체의 정보를 수정하는 메소드 
		 public int updateMember(Member m) { 
		 Connection conn = getConnection(); 
		 int result = new MemberDao().updateMember(conn, m); 
		 
		 if(result > 0) commit(conn); 
		 else rollback(conn); 
		 close(conn); 
		 
		 return result; 
		 } 
		// 멤버 객체의 삭제를 요청하는 메소드 
		 public int deleteMember(String id) { 
		 Connection conn = getConnection(); 
		 int result = new MemberDao().deleteMember(conn, id); 
		 
		 if(result > 0) commit(conn); 
		 else rollback(conn); 
		 close(conn); 
		 
		 return result; 
		 } 
	} 

