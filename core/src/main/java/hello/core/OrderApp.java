package hello.core;

import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {
	public static void main(String[] args) {
//		MemberService memberService = new MemberServiceImpl();
//		OrderService orderService = new OrderServiceImpl();
//		
//		Long memberId = 1L;
//		Member member = new Member(memberId,"MemberA",Grade.VIP);
//		
//		memberService.join(member);
//		
//		Order order = orderService.createOrder(memberId, "ItemA", 10000);
//		
//		
//		System.out.println(order);
//		
//		System.out.println("cal price = " + order.calculatePrice());
		
		
		// 위의 코드는 의존성 주입을 사용하지 않은 코드이다.
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		
		Long memberId = 1L;
		Member member = new Member(memberId,"MemberA",Grade.VIP);
		
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "ItemA", 10000);
		
		
		System.out.println(order);
		
		System.out.println("cal price = " + order.calculatePrice());
	}
}
