package com.greedy.section01.javaconfig.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.MemberDAO;
import com.greedy.section01.javaconfig.MemberDTO;

public class Application4 {

	public static void main(String[] args) {
		
		/* 베이스 패키지로 사용할 경로를 문자열 형태의 인자로 전달하면 해당 경로를 basePackage로 설정하여 스캔한다.
		 * 아래와 같이 여러개의 basePackage를 설정할 수 있다.
		 * */
		ApplicationContext context 
			= new AnnotationConfigApplicationContext("com.greedy.section01.javaconfig"
													, "com.greedy.section01.javaconfig.config");
		
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
