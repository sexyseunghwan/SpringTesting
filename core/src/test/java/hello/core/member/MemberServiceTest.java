package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {

	//MemberService memberService = new MemberServiceImpl();
	MemberService memberService; 
	
	
	// test 를 실행하기 전에 선행작업을 진행해준다.
	@BeforeEach
	public void beforEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	@Test
	void join() {
		
		//given
		Member member = new Member(1L, "MemberA", Grade.VIP);
		
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(member.getId());
		
		//then
		Assertions.assertThat(member).isEqualTo(findMember);
		
		
		
	}
}
