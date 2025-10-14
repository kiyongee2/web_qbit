package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.common.DBUtil;

public class MemberDAO {
	//회원 가입
	public void addMember(Member member) {
		String sql = "insert into member(mid, passwd, name, gender, joindate) "
				+ "values (?, ?, ?, ?, now())";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, member.getMid());
				pstmt.setString(2, member.getPasswd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				
				pstmt.executeUpdate();  //실행
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 목록
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		String sql = "select * from member";
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				Member member = new Member(
					rs.getString("mid"),
					rs.getString("passwd"),
					rs.getString("name"),
					rs.getString("gender"),
					rs.getTimestamp("joindate")
				);
				
				list.add(member);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//로그인
	public boolean checkLogin(Member member) {
		String sql = "select * from member where mid=? and passwd=?";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getPasswd());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//회원 상세 보기
	public Member getMember(String mid) {
		Member member = new Member();
		String sql = "select * from member where mid = ?";
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, mid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setMid(rs.getString("mid"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setGender(rs.getString("gender"));
				member.setJoinDate(rs.getTimestamp("joindate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}












