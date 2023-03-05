package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDicountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

/**
 * 애플리케이션 전체를 설정하고 구성한다.
 * 
 * @author sinseunghwan
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(discountPolicy(), memberRepository());
	}
	
	
	// 사용영역과 구성 영역을 분리했기 때문에 정액 할인에서 정률 할인으로 바꾸더라도 아래의 코드만 간단하게 바꿔주면 된다.
	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDicountPolicy();
		return new RateDiscountPolicy();
	}
	
}

