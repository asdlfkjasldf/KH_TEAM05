package com.indimoa.member.model.vo;

import java.sql.Timestamp;

//MM_ID         NOT NULL VARCHAR2(20)  
//MM_PWD        NOT NULL VARCHAR2(20)  
//MM_EMAIL      NOT NULL VARCHAR2(20)  
//MM_PHN        NOT NULL VARCHAR2(20)  
//MM_COM        NOT NULL VARCHAR2(20)  
//MM_ENROLLDATE NOT NULL TIMESTAMP(6)  
//MM_PROFILE    NOT NULL VARCHAR2(255) 
//MM_NICKNAME   NOT NULL VARCHAR2(255) 
//MM_MEMBERSHIP NOT NULL VARCHAR2(20)  
//MM_NAME       NOT NULL VARCHAR2(20) 

public class Member {
	private String mm_id;
	private String mm_pwd;
	private String mm_email;
	private String mm_phn;
	private String mm_com;
	private Timestamp mm_enrolldate;
	private String mm_profile;
	private String mm_nickname;
	private String mm_membership;
	private String mm_name;
	private int mm_point;

	public Member() {}

	public Member(String mm_id, String mm_pwd, String mm_email, String mm_phn, String mm_com,
			Timestamp mm_enrolldate, String mm_profile, String mm_nickname, String mm_membership, String mm_name, int mm_point) {
		super();
		this.mm_id = mm_id;
		this.mm_pwd = mm_pwd;
		this.mm_email = mm_email;
		this.mm_phn = mm_phn;
		this.mm_com = mm_com;
		this.mm_enrolldate = mm_enrolldate;
		this.mm_profile = mm_profile;
		this.mm_nickname = mm_nickname;
		this.mm_membership = mm_membership;
		this.mm_name = mm_name;
		this.mm_point = mm_point;
	}
	
	public Member(String mm_id) {
		this.mm_id = mm_id;
	}





	@Override
	public String toString() {
		return "Member [mm_id=" + mm_id + ", mm_pwd=" + mm_pwd + ", mm_email=" + mm_email + ", mm_phn="
				+ mm_phn + ", mm_com=" + mm_com + ", mm_enrolldate=" + mm_enrolldate + ", mm_profile=" + mm_profile
				+ ", mm_nickname=" + mm_nickname + ", mm_membership=" + mm_membership + ", mm_name=" + mm_name + ", mm_point=" + mm_point + "]";
	}

	public String getMm_id() {
		return mm_id;
	}

	public void setMm_id(String mm_id) {
		this.mm_id = mm_id;
	}

	public String getMm_pwd() {
		return mm_pwd;
	}

	public void setMm_pwd(String mm_pwd) {
		this.mm_pwd = mm_pwd;
	}

	public String getMm_email() {
		return mm_email;
	}

	public void setMm_email(String mm_email) {
		this.mm_email = mm_email;
	}

	public String getMm_phn() {
		return mm_phn;
	}

	public void setMm_phn(String mm_phn) {
		this.mm_phn = mm_phn;
	}

	public String getMm_com() {
		return mm_com;
	}

	public void setMm_com(String mm_com) {
		this.mm_com = mm_com;
	}

	public Timestamp getMm_enrolldate() {
		return mm_enrolldate;
	}

	public void setMm_enrolldate(Timestamp mm_enrolldate) {
		this.mm_enrolldate = mm_enrolldate;
	}

	public String getMm_profile() {
		return mm_profile;
	}

	public void setMm_profile(String mm_profile) {
		this.mm_profile = mm_profile;
	}

	public String getMm_nickname() {
		return mm_nickname;
	}

	public void setMm_nickname(String mm_nickname) {
		this.mm_nickname = mm_nickname;
	}

	public String getMm_membership() {
		return mm_membership;
	}

	public void setMm_membership(String mm_membership) {
		this.mm_membership = mm_membership;
	}

	public String getMm_name() {
		return mm_name;
	}

	public void setMm_name(String mm_name) {
		this.mm_name = mm_name;
	}
	
	public int getPoint() {
		return mm_point;
	}
	public void setPoint(int point) {
		this.mm_point = point;
	}

}
