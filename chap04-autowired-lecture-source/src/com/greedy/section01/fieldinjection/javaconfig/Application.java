package com.greedy.section01.fieldinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* @Autowired를 이용한 의존성 주입 
		 * 스프링 3.1 이후 버전부터 어노테이션을 이용한 bean 생성 및 의존성 주입을 위한 어노테이션을 제공한다.
		 * */
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section01.fieldinjection.javaconfig");
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			
			System.out.println("beanName : " + beanName);
		}
		
		BookService bookService = context.getBean("bookService", BookService.class);
		
		/* 전체 목록 조회 */
		for(BookDTO book : bookService.selectAllBooks()) {
			
			System.out.println(book);
		}
		
		/* 시퀀스로 검색 */
		System.out.println(bookService.searchBookSequence(2));
	}
}
