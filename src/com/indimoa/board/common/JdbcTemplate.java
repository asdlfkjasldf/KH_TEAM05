package com.indimoa.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcTemplate {

	public JdbcTemplate() {
	}

	public static Connection getConnection() {
		Connection conn = null;
	
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");  //Tomcat resource 설정을 찾기 server.xml;
			DataSource ds = (DataSource)envContext.lookup("jdbc/indimoaDclass");   // jdbc/indimoaDclass   // jdbc/indimoaLocal
			conn = ds.getConnection();
			if(conn!=null) System.out.println("2021 10 08 DBCP JNDI 연결성공");
			else System.out.println("2021 10 08 DBCP JNDI 연결실패");
			//톰캣에 있는 설정파일 위치에서 찾아주란 뜻
			//javax.naming 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			Class.forName(dr);
//			conn = DriverManager.getConnection(url, uid, pwd);
//			if(conn!=null) System.out.println("연결성공");
//			else System.out.println("연결실패!!!!!!!!!!!!!");
//		}catch(Exception e) {
//			System.out.println("연결실패!!!!!!!!!!!!!");
//			e.printStackTrace();
//		}
//		setAutoCommit(conn, false);
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement s) {
		try {
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public static void close(PreparedStatement s) {
//		try {
//			s.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static void close(ResultSet s) {
		try {
			if(s!=null) s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void setAutoCommit(Connection conn, boolean onOff) {
		try {
			conn.setAutoCommit(onOff);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
