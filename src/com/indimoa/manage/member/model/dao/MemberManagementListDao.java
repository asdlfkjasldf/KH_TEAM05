package com.indimoa.manage.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.indimoa.common.JdbcTemplate;
import com.indimoa.member.model.vo.Member;


public class MemberManagementListDao {

	
	public int getBoardCount(Connection conn) {

		int result = 0;
		String sql = "select count(mm_id)  from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);// 인덱스
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	public ArrayList<Member> searchMember(Connection conn, Member vo) {
		ArrayList<Member> volist = null;
		
		final String sqlselectwithId = "select * from MEMBER where mm_id like '%'||?||'%'";
		final String sqlselectwithName = "select * from MEMBER where mm_name like '%'||?||'%'";
		final String sqlselectwithNickname = "select * from MEMBER where mm_nickname like '%'||?||'%'"; 
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String flagBoardListFromSearch = "N";
		
			
		
		
		
		try {
			pstmt = conn.prepareStatement(sqlselectwithId);
			
			if (vo.getSearchCondition() != null && vo.getSearchKeyword() != null) {
				flagBoardListFromSearch = "Y";
			}
			
			
			if("Y".equals(flagBoardListFromSearch) && vo.getSearchCondition().equals("ik")) {
				pstmt = conn.prepareStatement(sqlselectwithId);
				pstmt.setString(1, vo.getSearchKeyword());
			} else if("Y".equals(flagBoardListFromSearch) && vo.getSearchCondition().equals("nk") ) {
				pstmt = conn.prepareStatement(sqlselectwithName);
				pstmt.setString(1, vo.getSearchKeyword());
			} else if ("Y".equals(flagBoardListFromSearch) && vo.getSearchCondition().equals("nik")) {
				pstmt = conn.prepareStatement(sqlselectwithNickname);
				pstmt.setString(1, vo.getSearchKeyword());
			}
			
			
			pstmt.setString(1, vo.getSearchKeyword());
			rset = pstmt.executeQuery();
			volist = new ArrayList<Member>();
			if (rset.next()) {
				do {
					Member vo2 = new Member();
					vo2.setMm_id(rset.getString("mm_id"));
					vo2.setMm_pwd(rset.getString("mm_pwd"));
					vo2.setMm_email(rset.getString("mm_email"));
					vo2.setMm_phn(rset.getString("mm_phn"));
					vo2.setMm_com(rset.getString("mm_com"));
					vo2.setMm_enrolldate(rset.getTimestamp("mm_enrolldate"));
					vo2.setMm_profile(rset.getString("mm_profile"));
					vo2.setMm_nickname(rset.getString("mm_nickname"));
					vo2.setMm_membership(rset.getString("mm_membership"));
					vo2.setMm_name(rset.getString("mm_name"));
					vo2.setMm_name(rset.getString("mm_point"));
					volist.add(vo2);
				} while (rset.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("[admin]-- 리턴은" + volist);
		return volist;
	}
	
	
	

	public ArrayList<Member> selectBoardList(Connection conn, int startRnum, int endRnum) {
		ArrayList<Member> volist = null;

		String sql = "select *  from (select Rownum r, t1.* from (select * from member order by mm_enrolldate asc, mm_id asc) t1) t2 where r between ? and ?";
		;
//		"select *  from (   select Rownum r, t1.* from (select * from member order by mm_enrolldate desc, mm_id desc) t1) t2 where r between ? and ?"
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rset = pstmt.executeQuery();
			volist = new ArrayList<Member>();
			if (rset.next()) {
				do {
					Member vo = new Member();
					vo.setMm_id(rset.getString("mm_id"));
					vo.setMm_pwd(rset.getString("mm_pwd"));
					vo.setMm_email(rset.getString("mm_email"));
					vo.setMm_phn(rset.getString("mm_phn"));
					vo.setMm_com(rset.getString("mm_com"));
					vo.setMm_enrolldate(rset.getTimestamp("mm_enrolldate"));
					vo.setMm_profile(rset.getString("mm_profile"));
					vo.setMm_nickname(rset.getString("mm_nickname"));
					vo.setMm_membership(rset.getString("mm_membership"));
					vo.setMm_name(rset.getString("mm_name"));
					volist.add(vo);
				} while (rset.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("[admin]-- 리턴은" + volist);
		return volist;
	}
	public int insertMemberBoardList(Connection conn, Member vo) {
		int result =-1;
		ArrayList<Member> volist = null;

		String sqlInsert = "INSERT INTO MEMBER"
				+ "(MM_ID, MM_PWD, MM_EMIAL, MM_PHN, MM_COM , MM_ENROLLDATE, MM_PROFILE, MM_NICKNAME, MM_MEMBERSHIP, MM_NAME, MM_POINT)"
				+ " VALUES(?,?,?,?,?,SYSTIMESTAMP, ?,?,?,?,?)";
		PreparedStatement pstmt = null;
		

		try {
					
					pstmt = conn.prepareStatement(sqlInsert);
					pstmt.setString(1, vo.getMm_id());
					pstmt.setString(2, vo.getMm_pwd());
					pstmt.setString(3, vo.getMm_email());
					pstmt.setString(4, vo.getMm_phn());
					pstmt.setString(5, vo.getMm_com());
					pstmt.setString(6, vo.getMm_profile());
					pstmt.setString(7, vo.getMm_nickname());
					pstmt.setString(8, vo.getMm_membership());
					pstmt.setString(9, vo.getMm_name());
					pstmt.setInt(10, vo.getMm_point());
					
					result = pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
			}
		System.out.println("[admin]-- 리턴은" + volist);
		return result;
	}
	
	
	public int deleteMemberBoardList(Connection conn, Member vo) {
		int result = -1;
		ArrayList<Member> volist = null;
		
		String sqlDelete = "DELETE FROM MEMBER WHERE MM_ID = ?";
				
				
		
		PreparedStatement pstmt  = null;
		try {
			pstmt = conn.prepareStatement(sqlDelete);
			pstmt.setString(1, vo.getMm_id());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		}
		
		System.out.println("[admin]-- 강제탈퇴한 회원은" + volist);
		return result;
		
	}
//	업데이트문은 일단 보류
//	public int updateMemberBoardList(Connection conn, Member vo) {
//		int result =-1;
//
//
//		String sqlDelete = "UPDATE member SET title = ? , content = ? WHERE mm_id = ?";
//		PreparedStatement pstmt= null;
//		try {
//				pstmt = conn.prepareStatement(sqlDelete);
//				pstmt.setString(1, vo.getTitle());
//				pstmt.setString(2, vo.getContent());
//				pstmt.setInt(3, vo.getBno());
//				
//				result = pstmt.executeUpdate();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			JdbcTemplate.close(pstmt);
//		}
//		return result;
//	}
	
	
	
	
	
	
//	상세정보 기능으로 전환시 사용
//	public Member userDetail(Connection conn, String userid) {
//		ArrayList<Member> volist = null;
//		Member m = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		volist = new ArrayList<Member>();
//		String sql = "select * from MEMBER where mm_id = ?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			rset = pstmt.executeQuery();
//			volist = new ArrayList<Member>();
//			if (rset.next()) {
//				do {
//					Member vo = new Member();
//					vo.setMm_id(rset.getString("mm_id"));
//					vo.setMm_pwd(rset.getString("mm_pwd"));
//					vo.setMm_email(rset.getString("mm_email"));
//					vo.setMm_phn(rset.getString("mm_phn"));
//					vo.setMm_com(rset.getString("mm_com"));
//					vo.setMm_enrolldate(rset.getTimestamp("mm_enrolldate"));
//					vo.setMm_profile(rset.getString("mm_profile"));
//					vo.setMm_nickname(rset.getString("mm_nickname"));
//					vo.setMm_membership(rset.getString("mm_membership"));
//					vo.setMm_name(rset.getString("mm_name"));
//					volist.add(vo);
//				} while (rset.next());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JdbcTemplate.close(rset);
//			JdbcTemplate.close(pstmt);
//		}
//
//		return m;
//	}

	public int insertPointMemberBoard(Connection conn, Member vo) {
		int result =-1;
		ArrayList<Member> volist = null;

		String sqlInsert = "UPDATE MEMBER SET MM_POINT =  ? WHERE MM_ID = ?";
		PreparedStatement pstmt = null;
		

		try {
					pstmt = conn.prepareStatement(sqlInsert);
					pstmt.setInt(1, vo.getPoint());
					pstmt.setString(2, vo.getMm_id());
					
					result = pstmt.executeUpdate();
					System.out.println(result);
					JdbcTemplate.commit(conn);
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				JdbcTemplate.close(pstmt);
			}
		System.out.println("[admin]-- 리턴은" + volist);
		return result;
	}
	

}
