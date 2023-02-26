package hello.core.Order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

	//private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	
	// private final DiscountPolicy discountPolicy = new FixDicountPolicy();
	// private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	// 위의 코드는 DIP 를 위반하였다.
	// 아래와 같이 설계하면 인터페이스만 의존하는 설계를 완성했지만. -> null pointer exception 이 발생할 것이다.
	private DiscountPolicy discountPolicy;
	private MemberRepository memberRepository;
	
	public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
		this.discountPolicy = discountPolicy;
		this.memberRepository = memberRepository;
	}
	
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId,itemName,itemPrice,discountPrice);
	}



	
}
