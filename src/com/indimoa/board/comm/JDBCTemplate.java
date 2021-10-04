package com.indimoa.board.comm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
	public JDBCTemplate() {}
	public static Connection getConnection() {
		Connection conn = null;
//		String dr = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@112.221.156.36:1521:xe";  //TODO: 설명
//		String uid = "INDIMOA";
//		String pwd = "INDIMOA";
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");   //(Tomcat 설정된 resources를 찾으러 감) server.xml, contect.xml
			DataSource ds = (DataSource)envContext.lookup("jdbc/myLocaloracle");
			conn = ds.getConnection();
			if(conn != null) System.out.println("DBCP JNDI 연결성공");
			else System.out.println("DBCP JNDI 연결성공");
			if(conn != null) {
				System.out.println("연결 성공");
			}else {
				System.out.println("연결 실패");
			}
		}catch(Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		//여기에 넣는 경우 : DML 한개일 때
		//setAutoCommit(conn, false);
		return conn;
	}
	public static void close(Connection con) {
		try {
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement s) {
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet s) {
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void setAutoCommit(Connection conn, boolean onOff) {
		try {
			conn.setAutoCommit(onOff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

