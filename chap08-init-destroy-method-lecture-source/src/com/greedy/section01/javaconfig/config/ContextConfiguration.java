package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.javaconfig.Beverage;
import com.greedy.section01.javaconfig.Bread;
import com.greedy.section01.javaconfig.Owner;
import com.greedy.section01.javaconfig.Product;
import com.greedy.section01.javaconfig.ShoppingCart;

@Configuration
public class ContextConfiguration {

	@Bean
	public Product carpBread() {
		
		return new Bread("붕어빵", 1000, new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		
		return new Beverage("딸기우유", 1500, 500);
	}
	
	@Bean
	public Product water() {
		
		return new Beverage("지리산암반수", 3000, 500);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		
		return new ShoppingCart();
	}
	
	/* init메소드는 동작을 하지만 detory메소드는 현 시점에서는 동작하지 않는다.
	 *              (그래서 강제로 컨테이너를 종료하는 메소드를 Application에서 요청함)
	 * 
	 * 가비지컬렉터가 해당 빈을 메모리에서 지울 때 동작하게 되는데 메모리에서 지우기전에 
	 * 프로세스는 종료되기때문에 호출될 수 없다. 
	 * 그래서 웹쪽에서 쓸일이 있기때문에 설정하는 방법만 확인해둔다.
	 **/
	
	@Bean(initMethod = "openShop", destroyMethod = "closeShop")
	public Owner owner() {
		
		return new Owner();
	}
}
