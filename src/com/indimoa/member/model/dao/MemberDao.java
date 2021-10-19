package com.indimoa.member.model.dao;


import static com.indimoa.common.JdbcTemplate.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.indimoa.member.model.vo.Member;

public class MemberDao {
	
	
	private Properties prop = new Properties();

	public MemberDao() {}
	
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		if(instance == null)
			instance = new MemberDao();
		return instance;
	}
	
//	public Connection getConnection() throws Exception {
//		Connection conn = null;
//		Context initContext = new InitialContext();
//		Context envContent = (Context)initContext.lookup("java:/comp/env");   //TODO
//		DataSource ds = (DataSource)envContent.lookup("jdbc/INDIMOA");
//		conn = ds.getConnection();
//		return conn;
//		}

	
	public Member getMember(Connection conn, String id) {
		Member m = null;
		String query = "select mm_id, mm_pwd, mm_name, mm_email, mm_phn, mm_com, mm_profile, mm_nickname, mm_membership, mm_point from member where mm_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m = new Member();
				m.setMm_id(rset.getString("mm_id"));
				m.setMm_pwd(rset.getString("mm_pwd"));
				m.setMm_name(rset.getString("mm_name"));
				m.setMm_email(rset.getString("mm_email"));
				m.setMm_phn(rset.getString("mm_phn"));
				m.setMm_com(rset.getString("mm_com"));
				m.setMm_profile(rset.getString("mm_profile"));
				m.setMm_nickname(rset.getString("mm_nickname"));
				m.setMm_membership(rset.getString("mm_membership"));
				m.setMm_point(rset.getInt("mm_point"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	
	public int userCheck(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;

		// member 테이블에서 사용자 아이디가 id인 레코드의 pwd column을 조회
		String sql = "select mm_id, pwd from member where mm_id=?";

		try {
			conn = getConnection(); // DB 연결 시도
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pwd_in_db = rs.getString("pwd");
				if (pwd_in_db != null && pwd.equals(pwd_in_db)) {
					// id를 조건으로 pwd가 조회되면 입력받은 id가 존재한다는 의미.
					result = 1;
				} else {
					result = 0;
				}
			} else {
				// 조회한 결과가 값이 없으므로 id가 존재하지 않음.
				result = -1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	public Member loginMember( String id, String passwd) throws Exception {
		Member m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where mm_id = ? and mm_pwd = ?";
		try {
			
			conn = getConnection(); // DB 연결 시도
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
		ResultSet rs = null;
		int result = -1;

		String sql = "select mm_id from member where mm_id=?";

		try {
			conn = getConnection(); // DB 연결 시도
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);

			rs = pstmt.executeQuery();

			if (rs.next()) { // 조회 결과가 있으면 id가 존재한다는 의미
				result = 1;
			} else {
				// 조회한 결과가 값이 없으므로 id가 존재하지 않음.
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 닉네임 값의 중복을 조회하는 메소드
		public int dupNicknameChk(Connection conn, String nickname) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = -1;

			String sql = "select mm_nickname from member where mm_nickname=?";

			try {
				conn = getConnection(); // DB 연결 시도
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,nickname);

				rs = pstmt.executeQuery();

				if (rs.next()) { // 조회 결과가 있으면 id가 존재한다는 의미
					result = 1;
				} else {
					// 조회한 결과가 값이 없으므로 id가 존재하지 않음.
					result = -1;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return result;
		}

	// DataBase에 Member 객체를 추가하는 메소드
	public int insertMember(Connection conn, Member m) {
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
	public int selectId( String name, String email) {
				
		Connection conn = null;
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
			
			e.printStackTrace();
		}

		return result;
	}
	
	
	//database에서 해당 이름,아이디,이메일의 비밀번호를 찾아오는 메소드
	public int selectPwd(String name, String id, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = "select mm_pwd from member where mm_name = ? and mm_id = ? and mm_email = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
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
