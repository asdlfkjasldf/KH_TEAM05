package com.indimoa.member.model.dao;


import static com.indimoa.common.JdbcTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.indimoa.member.model.vo.Member;

public class MemberDao {
	
	
	private Properties prop = new Properties();

	public MemberDao() {}
	public Member loginMember(Connection conn, String id, String passwd) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where mm_id = ? and mm_pwd = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id); // 첫번째 ‘?’ 에 id 값 대입
			pstmt.setString(2, passwd); // 두번째 ‘?’ 에 passwd 값 대입
			rset = pstmt.executeQuery();
			if (rset.next()) { // 첫 열은 head 컬럼이므로 next() 로 실제 컬럼값을 가져온다.
				m = new Member();
				m.setMm_id(rset.getString("mm_id")); // 받아온 ID 컬럼 값을 member변수에 대입
				m.setMm_pwd(rset.getString("mm_pwd"));
				m.setMm_name(rset.getString("mm_name"));
				m.setMm_email(rset.getString("mm_email"));
				m.setMm_phn(rset.getString("mm_phn"));
				m.setMm_com(rset.getString("mm_com"));
				m.setMm_profile(rset.getString("mm_profile"));
				m.setMm_nickname(rset.getString("mm_nickname"));
				m.setMm_membership(rset.getString("mm_membership"));
				m.setPoint(rset.getInt("mm_point"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // ResultSet과 PreparedStatement 리소스를 반환
			close(rset);
			close(pstmt);
		}
		return m; // 조회하여 가져온 Member 객체를 반환한다
	}

	// ID 값의 중복을 조회하는 메소드
	public int dupIdChk(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		// id로 테이블을 조회하여 있으면 1 이상, 없으면 0인 쿼리 작성
		String query = "select * from member where mm_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1); // rset의 첫 컬럼의 숫자값을 가져온다
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	// DataBase에 Member 객체를 추가하는 메소드
	public int enrollMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values (?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMm_id());
			pstmt.setString(2, m.getMm_pwd());
			pstmt.setString(3, m.getMm_name());
			pstmt.setString(4, m.getMm_email());
			pstmt.setString(5, m.getMm_phn());
			pstmt.setString(6, m.getMm_com());
			pstmt.setString(7, m.getMm_profile());
			pstmt.setString(8, m.getMm_nickname());
			pstmt.setString(9, m.getMm_membership());
			pstmt.setInt(10, m.getPoint());
			
			// executeupdate() 는 실행 결과를 반영된 행의 개수로 리턴하므로
			// 1 이상은 실행 성공, 0 이하(구문 에러 포함)는 실패이다.
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 기존 사용자의 정보를 수정하여 DataBase의 데이터를 수정하는 메소드
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set " + "mm_pwd = ?, mm_email = ?, mm_phn = ?, mm_com = ?, mm_enroll_date = ?, mm_profile = ?, mm_nickname = ?, mm_membership = ?, mm_point = ? where mm_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMm_pwd());
			pstmt.setString(2, m.getMm_name());
			pstmt.setString(3, m.getMm_email());
			pstmt.setString(4, m.getMm_phn());
			pstmt.setString(5, m.getMm_com());
			pstmt.setString(6, m.getMm_profile());
			pstmt.setString(7, m.getMm_nickname());
			pstmt.setString(8, m.getMm_membership());
			pstmt.setInt(9, m.getPoint());
			pstmt.setString(10, m.getMm_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 기존 사용자를 DataBase에서 삭제하는 메소드
	public int deleteMember(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where mm_id = ? and mm_pwd = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	//멤버쉽을 업데이트 하는 메소드
	public int updateMembershipMember(Connection conn, String id, String membership) {
		int result = -1;
		String query = "update member set membership = membership + ? where mm_id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, membership);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		return result;
	}
	
	
	
	//database에서 해당 이름,이메일의 아이디를 찾아오는 메소드
	public int selectId(Connection conn, String name, String email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = "select mm_id from member where mm_name = ? and mm_email = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	
	//database에서 해당 이름,아이디,이메일의 비밀번호를 찾아오는 메소드
	public int selectPwd(Connection conn, String name, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = "select mm_pwd from member where mm_name = ? and mm_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
}
