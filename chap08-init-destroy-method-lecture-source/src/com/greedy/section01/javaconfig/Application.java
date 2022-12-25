package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/* 초기화와 폐기 메소드를 확인 
		 * -> bean을 초기화할 시 먼저 호출하고, 빈이 소멸될 때 자동으로 호출하는 메소들 설정
		 * */
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
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
		
		/* 강제로 컨테이너를 종료시키게되면 폐기 메소드가 동작한다. */
		((AnnotationConfigApplicationContext) context).close();
	}
}
