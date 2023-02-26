package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	
	public static void main(String[] args) {
		
		//MemberService memberService = new MemberServiceImpl();
		//Member member = new Member(1L,"memberA",Grade.VIP);
		//memberService.join(member);
		
		
		//Member findMember = memberService.findMember(member.getId());
		
		//System.out.println("New member = " + member);
		//System.out.println("Find Member = " + findMember);
		
		
		// 위에는 기존 코드
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		memberService.join(member);
		
		
		Member findMember = memberService.findMember(member.getId());

		System.out.println("New member = " + member);
		System.out.println("Find Member = " + findMember);
	}
}
