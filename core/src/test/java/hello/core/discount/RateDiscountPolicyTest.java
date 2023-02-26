package hello.core.discount;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	
	@Test
	@DisplayName("VIP 면 10% 할인이 적용됩니다.")
	void vip_o() {
		
		//given
		Member member = new Member(1L,"MemberVIP",Grade.VIP);
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		//then
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되면 안된다.")
	void vip_n() {
		
		//given
		Member member = new Member(1L,"MemberBasic",Grade.BASIC);
		
		//when
		int discount = discountPolicy.discount(member, 10000);
		
		//then
		assertThat(discount).isEqualTo(1000);
		
	}
	
}
