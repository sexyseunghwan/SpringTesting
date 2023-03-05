package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		// 아래의 코드는 의존성 주입을 사용한 코드이다.
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
//		
//		Long memberId = 1L;
//		Member member = new Member(memberId,"MemberA",Grade.VIP);
//		
//		memberService.join(member);
//		Order order = orderService.createOrder(memberId, "ItemA", 30000);
//		
//		
//		System.out.println(order);
//		
//		System.out.println("cal price = " + order.calculatePrice());
		
		
		
		// 아래는 스프링 프레임워크를 사용한 코드이다.
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		
		memberService.join(member);
		
		OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
		Order order = orderService.createOrder(member.getId(), "ItemA", 45000);
		
		System.out.println(order);
		
		System.out.println("cal price = " + order.calculatePrice());
		
	}
}
