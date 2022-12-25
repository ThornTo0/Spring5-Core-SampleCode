package com.greedy.section01.singleton.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.singleton.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 실행을 하게되면 현재 빈 구성은 singleton으로 설정되어있다.(기본값)
		 * singleton은 IoC컨테이너당 하나의 인스턴스만 생성한다.
		 * 
		 * 스프링의 빈 스코프
		 * singleton      IoC컨테이너당 빈 인스턴스 하나를 생성한다.
		 * prototype      요청할 때마다 빈 인스턴스를 새로 만든다.
		 * request        HTTP 요청당 하나의 빈 인스턴스를 생성합니다. 웹 애플리케이션 컨텍스트에만 해당된다.
		 * session        HTTP 세션당 빈 인스턴스 하나를 생성한다. 웹 애플리케이션 컨텍스트에만 해당된다.
		 * globalSession  전역 HTTP세션당 빈 인스턴스 하나를 생성한다. 포털 애플리케이션 컨텍스트에만 해당된다.
		 * */
		
		/* 손님 두명이 각각 카트를 이용해서 상품을 담았을 때 singleton으로 관리되는 cart의 값을 확인해보자
		 * --> 결과) 두 손님이 동일한카트에 물건을 담게된다.
		 * */
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			
			System.out.println("beanName : " + beanName);
		}
		
		Product carpBread = context.getBean("carpBread", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(milk);
		
		System.out.println("cart1에 담긴 내용 : " + cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(water);
		
		System.out.println("cart2에 담긴 내용 : " + cart2.getItem());
		
		System.out.println("cart1의 hashCode : " + cart1.hashCode());
		System.out.println("cart2의 hashCOde : " + cart2.hashCode());
	}
}
