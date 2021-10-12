package com.indimoa.manage.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.indimoa.common.JdbcTemplate;
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
	
	
	
	public ArrayList<Member> selectBoardList(Member vo) {
		ArrayList<Member> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = new MemberManagementListDao().searchMember(conn, vo);
		
		JdbcTemplate.close(conn);
		return volist;
	}

	
public int deleteMemberFromManagement(Member vo) {
	int result = -1;
	Connection conn = JdbcTemplate.getConnection();
	
	result = new MemberManagementListDao().deleteMemberBoardList(conn, vo);
	
	JdbcTemplate.close(conn);
	return result;
}
	
	
//	상세정보보기 기능으로 전환시 사용
//	 public Member userDetail(String userid) {
//		 Connection conn = JdbcTemplate.getConnection();
//		 Member m = new MemberManagementListDao().userDetail(conn, userid);
//		 JdbcTemplate.close(conn);
//		 return m;
//		}

	public int insertPointFromManagement(Member vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new MemberManagementListDao().insertPointMemberBoard(conn, vo);
		
		JdbcTemplate.close(conn);
		return 0;
	}



}
