package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		
//		Member member = new Member(1L,"memberA",Grade.VIP);
//		memberService.join(member);
//		
//		
//		Member findMember = memberService.findMember(member.getId());
//
//		System.out.println("New member = " + member);
//		System.out.println("Find Member = " + findMember);
		
		
		
		// 위에는 Spring을 사용하지 않은 코드이다.
		// 아래의 코드는 Spring 을 사용하는 코드이다.
		// 아래와 같이 인스턴스를 선언해주면, 지정한 config 에 있는 설정정보를 토대로 @Bean 으로 등록되어 있는 모든 것들을 
		// 스프링 컨테이너에 객체생성한 걸 다 집어넣어서 관리를 시작한다. -> 기본적으로 지정한 메서드 이름으로 등록이 된다.
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class); // AppConfig 에서 memberService() 메서드를 가져오게 된다.
		
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(member.getId());
		
		System.out.println("New member = " + member);
		System.out.println("Find Member = " + findMember);
		
	}
}
