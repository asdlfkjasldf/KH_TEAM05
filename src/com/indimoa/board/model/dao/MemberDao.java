package com.indimoa.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.indimoa.board.comm.JDBCTemplate;
import com.indimoa.board.member.model.vo.Member;

public class MemberDao {

	public MemberDao() {}
	//login
	public int login(Connection conn, String mm_id, String mm_pwd) {
		int result = 0;
		String query = "select mm_id, mm_pwd from member where mm_id like ? and mm_pwd like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, mm_id);
			ps.setString(2, mm_pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = 1;  //로그인성공-1, 실패-0
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return result;
	}
	public int checkDuplicatedMember(Connection conn, Member vo) {
		int result = -1;
		String query = "select mm_id from member where mm_id like ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getMm_id());
			rs = ps.executeQuery();
			if(rs.next()) {
				result = 2;
			}else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}
	//create
	public int insertMember(Connection conn, Member vo) {
		int result = -1;
		String query = "insert into member(mm_id, mm_pwd, mm_email, mm_phn, mm_com, mm_enrolldate, mm_profile, mm_nickname, mm_membership) values (?, ?, ?, ?, ?, sysdate, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getMm_id());
			ps.setString(2, vo.getMm_pwd());
			ps.setString(3, vo.getMm_email());
			ps.setString(4, vo.getMm_phn());
			ps.setString(5, vo.getMm_com());
			ps.setString(6, vo.getMm_profile());
			ps.setString(7, vo.getMm_nickname());
			ps.setString(8, vo.getMm_membership());
			result = ps.executeUpdate();
		}catch (Exception e) {
			//-1
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}
	//read
	public ArrayList<Member> selectMember(Connection conn) {
		ArrayList<Member> voList = null;
		try {
			Statement st = conn.createStatement();
			String query = "SELECT * FROM member";
			ResultSet rs = st.executeQuery(query);
			
			voList = new ArrayList<Member>();
			while(rs.next()) {
				Member vo = new Member();
				vo.setMm_id(rs.getString("mm_id"));
				vo.setMm_pwd(rs.getString("mm_pwd"));
				vo.setMm_email(rs.getString("mm_email"));
				vo.setMm_phn(rs.getString("mm_phn"));
				vo.setMm_com(rs.getString("mm_com"));
				vo.setMm_enrolldate(rs.getDate("mm_enroll_date"));
				vo.setMm_profile(rs.getString("mm_profile"));
				vo.setMm_nickname(rs.getString("mm_nickname"));
				vo.setMm_membership(rs.getString("mm_membership"));
				voList.add(vo);
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return voList;
	}
	//update
	public int updateMember(Connection conn, Member vo, String checkPwd) {
		int result = -1;
		try {
			String check = "SELECT * FROM member WHERE mm_pwd like ?";
			PreparedStatement ps = conn.prepareStatement(check);
			ps.setString(1, vo.getMm_id());
			ResultSet rs = ps.executeQuery();
			/*
			 * return : 0 - 변경 성공, 1 = pwd불일치, -1 에러
			 */
			if(rs.next()) {
				String dbPwd = rs.getString(1);
				if(checkPwd == dbPwd) {
					String query = "update member set mm_pwd = ?, mm_email = ?, mm_phn = ?, mm_com = ?, mm_enroll_date = ?, mm_profile = ?, mm_nickname = ?, mm_membership = ? where mm_id like ?";
					ps = conn.prepareStatement(query);
					ps.setString(1, vo.getMm_pwd());
					ps.setString(2, vo.getMm_email());
					ps.setString(3, vo.getMm_phn());
					ps.setString(4, vo.getMm_com());
					ps.setDate(5, vo.getMm_enrolldate());
					ps.setString(6, vo.getMm_profile());
					ps.setString(7, vo.getMm_nickname());
					ps.setString(8, vo.getMm_membership());
					ps.close();
					result = 0;
				}else {
					//mm_pwd 틀림
					result = -1;
				}
			}
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		return result;
	}
	
	//delete
	public int deleteMember(Connection conn, String id, String pwd) {
		int result = -1;
		try {
			String query = "delete from member where mm_id like ? and mm_pwd like ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			result = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		return result;
	}
	public int updateMembershipMember(Connection conn, String id, String membership) {
		int result = -1;
		String query = "update member set membership = membership + ? where mm_id like ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, membership);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}
}
