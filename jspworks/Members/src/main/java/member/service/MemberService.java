package member.service;

import java.util.List;

import member.model.Member;
import member.model.MemberDAO;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	//회원 가입
	public void addMember(Member member) {
		dao.addMember(member);
	}
	
	//회원 목록
	public List<Member> getMemberList(){
		return dao.getMemberList();
	}
	
	//로그인
	public boolean checkLogin(Member member) {
		return dao.checkLogin(member);
	}
}
