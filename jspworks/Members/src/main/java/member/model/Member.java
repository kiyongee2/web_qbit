package member.model;

import java.sql.Timestamp;

public class Member {
	private String mid;
	private String passwd;
	private String name;
	private String gender;
	private Timestamp joinDate;
	
	public Member() {}  //기본 생성자
	
	public Member(String mid, String passwd, String name, String gender, 
			Timestamp joinDate) {
		this.mid = mid;
		this.passwd = passwd;
		this.name = name;
		this.gender = gender;
		this.joinDate = joinDate;
	}



	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
}
