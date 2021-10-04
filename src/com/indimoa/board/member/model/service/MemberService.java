package com.indimoa.board.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.board.comm.JDBCTemplate;
import com.indimoa.board.member.model.vo.Member;
import com.indimoa.board.model.dao.MemberDao;
import com.indimoa.board.comm.JDBCTemplate.*;

public class MemberService {

	public MemberService() {}
	//login
	public int login(String mm_id, String mm_pwd) {
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		
		result = new MemberDao().login(conn, mm_id, mm_pwd);
		JDBCTemplate.close(conn);
		return result;
	}
	//create
	public int insertMember(Member vo) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		
		JDBCTemplate.setAutoCommit(conn, false);
		
		result = new MemberDao().checkDuplicatedMember(conn, vo);
		//회원있으면 2, 없으면 0, 오류발생 -1
		if(result == 0) {
			//입력된 값으로회원가입
			result = new MemberDao().insertMember(conn, vo);			
		}
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.Rollback(conn);
		}
		JDBCTemplate.Rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	//read
	public ArrayList<Member> selectMember() {
		ArrayList<Member> voList = null;
		Connection conn = JDBCTemplate.getConnection();
		
		voList = new MemberDao().selectMember(conn);
		JDBCTemplate.close(conn);
		return voList;
	}
	//update
	public int updateMember(Member vo, String checkPwd) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().updateMember(conn, vo, checkPwd);
		JDBCTemplate.close(conn);
		return result;
	}
	//delete
	public int deleteMember(String id, String pwd) {
		int result = -1;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().deleteMember(conn, id, pwd);
		JDBCTemplate.close(conn);
		return result;
	}

}
