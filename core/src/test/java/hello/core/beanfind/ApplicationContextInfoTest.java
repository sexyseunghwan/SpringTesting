package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class ApplicationContextInfoTest {
	
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("모든 빈 출력해주기")
	void findAllBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		for (String beanName : beanDefinitionNames) {
			Object bean = ac.getBean(beanName);
			System.out.println("name = " + beanName + " object = " + bean);
			//System.out.println(str);
		}
	}
	
	
	@Test
	@DisplayName("애플리케이션 관련 빈 출력해주기")
	void findApplicationBean() {
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		
		for (String beanName : beanDefinitionNames) {
			
			BeanDefinition beanDef = ac.getBeanDefinition(beanName);
			
			
			// ROLE_APPLICATION : 내가 애플리케이션을 개발하기 위해 등록한 빈이다.
			if (beanDef.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("내가 등록한 빈!");
				Object bean = ac.getBean(beanName);
				System.out.println("name = " + beanName + " object = " + bean);
			} 
			// ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
			else if (beanDef.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println("스프링이 직접 등록한 빈!");
				Object bean = ac.getBean(beanName);
				System.out.println("name = " + beanName + " object = " + bean);
			}
			//Object bean = ac.getBean(beanName);
			//System.out.println("name = " + beanName + " object = " + bean);
			//System.out.println(str);
		}
	}
	
	
	
	
	
	
}
