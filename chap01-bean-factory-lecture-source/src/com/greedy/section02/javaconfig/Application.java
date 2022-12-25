package com.greedy.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* AnnotationConfigApplicationContext라는 어노테이션 설정 정보를 읽어서
		 * 컨테이너를 설정하는 구현체를 이용할 것이다.
		 * 
		 * --> 인자로 @Configuration 어노테이션이 달린 설정 클래스의 메타정보를 전달하여
		 *     인스턴스를 생성
		 * */
		ApplicationContext context 
			= new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		MemberDTO member = (MemberDTO) context.getBean("member");
		System.out.println(member);
	}
}
