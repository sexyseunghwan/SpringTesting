package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		
		MemberService memberService = ac.getBean("memberService",MemberService.class);
		
		System.out.println("memberService : " + memberService);
		System.out.println("memberService.getClass : " + memberService.getClass());
		
		// 확인해주는 메서드
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		
	}
	
	
	
	@Test
	@DisplayName("이름없이 타입으로 조회")
	void findBeanByType() {
		
		MemberService memberService = ac.getBean(MemberService.class);// 이름을 빼도 동작은 한다.
		
		System.out.println("memberService : " + memberService);
		System.out.println("memberService.getClass : " + memberService.getClass());
		
		// 확인해주는 메서드
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		
	}
	
	
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName2() {
		
		// 추상화타입으로 데이터를 받거나 구체 타입으로 받거나 상관이 없다. 모두 정상적으로 작동한다.
		MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
		
		System.out.println("memberService : " + memberService);
		System.out.println("memberService.getClass : " + memberService.getClass());
		
		// 확인해주는 메서드
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		
	}
	
	
	@Test
	@DisplayName("빈 이름으로 조회했는데 없을 경우")
	void findBeanError() {
		//MemberService memberService = ac.getBean("xxxxx",MemberServiceImpl.class);
		
		// 아래의 코드의 뜻은 왼쪽에 적힌 예외가 터져야 된다는 뜻이된다.
		// 즉 ac.getBean(~)을 실행하였을 경우에 NoSuchBeanDefinitionException 예외가 발생해야 test 결과가 참이 된다.
		org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
				() -> ac.getBean("xxxxx",MemberServiceImpl.class));
		
	}
	
	
}
