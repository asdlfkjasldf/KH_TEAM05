package com.indimoa.manage.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.board.common.JdbcTemplate;
import com.indimoa.manage.member.model.dao.MemberManagementListDao;
import com.indimoa.member.model.vo.Member;




public class MemberManagementListService {

	
	
	
	public int getBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		result = new MemberManagementListDao().getBoardCount(conn);
		JdbcTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Member> selectBoardList(int startRnum, int endRnum) {
		ArrayList<Member> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = new MemberManagementListDao().selectBoardList(conn,startRnum,endRnum);
		
		JdbcTemplate.close(conn);
		return volist;
	}
	
//	public ArrayList<Member> insertBoardList(Member vo) {
//		int result = -1;
//		Connection conn = JdbcTemplate.getConnection();
//		JdbcTemplate.setAutoCommit(conn, false);
//		
//		
//			
//		
//		 reuslt = new MemberManagementListDao().insertMemberBoardList(conn, vo);
//		
//		JdbcTemplate.close(conn);
//		return result;
//	}
	
public int deleteMemberFromManagement(Member vo) {
	int result = -1;
	Connection conn = JdbcTemplate.getConnection();
	
	result = new MemberManagementListDao().deleteMemberBoardList(conn, vo);
	
	JdbcTemplate.close(conn);
	return result;
}
	
	
	
	 public Member userDetail(String userid) {
		 Connection conn = JdbcTemplate.getConnection();
		 Member m = new MemberManagementListDao().userDetail(conn, userid);
		 JdbcTemplate.close(conn);
		 return m;
		}



}
