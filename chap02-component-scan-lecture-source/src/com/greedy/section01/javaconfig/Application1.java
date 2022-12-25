package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {
		
		/* ComponentScan 기능을 이용한 bean 등록 설정을 해 볼것이다.
		 * 
		 * ComponentScan이란?
		 * base-package로 설정된 경로 하위에 특정 어노테이션을 가지고 있는 클래스를 이용하여 bean으로 등록한다.
		 * @Component 어노테이션이 작성된 클래스를 인식하여 bean으로 만들게 되며, 특수 목적에 따라 세부기능을 제공하는
		 * @Controller, @Service, @Repository, @Configuration등을 인식한다.
		 * */
		
		/* 어노테이션 설정을 읽는 ApplicationContext 하위 구현체는 AnnotationConfigApplicationContext이다.*/
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		/* bean으로 등록된 name들을 전부 확인할 때 사용하는 메소드
		 * Processor와 이벤트리스너, 설정클래스가 빈으로 등록된것을 확인할 수 있다.
		 * 하지만 memberDAO라는 이름의 bean은 존재하지 않는다.
		 * */
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String beanName : beanNames) {
			
			System.out.println("beanName : " + beanName);
		}
		
		MemberDAO memberDAO = context.getBean(MemberDAO.class);
		
		System.out.println(memberDAO.selectMember(1));
		System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "새로운멤버")));
		System.out.println(memberDAO.selectMember(3));
		
	}
}
