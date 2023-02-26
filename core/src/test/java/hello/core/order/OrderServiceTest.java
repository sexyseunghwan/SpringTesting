package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderServiceTest {
	//MemberService memberService = new MemberServiceImpl();
	//OrderService orderService = new OrderServiceImpl();
	
	
	// 의존주입을 해준다.
	MemberService memberService;
	OrderService orderService;
	
	
	@BeforeEach
	public void beforEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId,"MemberA",Grade.VIP);
		
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "ItemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}	
}
