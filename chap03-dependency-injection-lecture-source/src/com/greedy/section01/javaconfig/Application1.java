package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {
		
		/* 여러 개의 bean 상호작용(조립)
		 * 
		 * 한 명 회원이 하나의 계좌 정보를 가지고 있는 1:1 association 관계를 만들고 확인해보자
		 * */
		
		ApplicationContext context 
			= new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			
			System.out.println("beanName : " + beanName);
		}
		
		MemberDTO member = context.getBean(MemberDTO.class);
		System.out.println(member);
		
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().deposit(1000000));
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().withDraw(500000));
		System.out.println(member.getPersonalAccount().getBalance());
	}
}
