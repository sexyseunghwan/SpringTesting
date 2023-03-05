package hello.core.beanfind;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {
	
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
	void findBeanByTypeDuplicate() {
		
		// 타입만 지정했으니 오류가 발생된다. -> 왜냐면 아래 컨피그 클래스에 이름은 다르지만 타입이 같은 빈으로 등록된 메서드가 2개이기 때문이다.
		//ac.getBean(MemberRepository.class);
		
		
		org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
				() -> ac.getBean(MemberRepository.class));
	}
	
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정해주면 된다!")
	void findBeanTypeDuplicateSolve() {
		MemberRepository mr = ac.getBean("memberRepos1",MemberRepository.class);
		
		Assertions.assertThat(mr).isInstanceOf(MemberRepository.class);
	}
	
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 그냥 두개 다 꺼내고 싶다.")
	void findBeanTypeDuplicateList() {
		Map<String,MemberRepository> mrl = ac.getBeansOfType(MemberRepository.class);
		
		//System.out.println(mrl.get("memberRepos1"));
		//System.out.println(mrl.get("memberRepos2"));
		
		for (String key : mrl.keySet()) {
			System.out.println("key = " + key + " value = " + mrl.get(key));
		}
		
	}
	
	
	@Configuration
	static class SameBeanConfig {
		
		@Bean
		public MemberRepository memberRepos1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepos2() {
			return new MemoryMemberRepository();
		}
		
	}
}
