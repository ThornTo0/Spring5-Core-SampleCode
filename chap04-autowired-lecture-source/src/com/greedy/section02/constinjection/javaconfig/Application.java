package com.greedy.section02.constinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.constinjection.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/* 의존성 주입 중에서 생성자 주입 */
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			
			System.out.println(beanName);
		}
		
		MakeRandomString randomString = context.getBean(MakeRandomString.class);
		
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
		System.out.println(randomString.getRandomLengthString());
	}
}
