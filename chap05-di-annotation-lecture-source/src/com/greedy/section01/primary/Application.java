package com.greedy.section01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 한 개의 인터페이스를 상속받은 여러 클래스를 모두 Bean으로 등록한 경우
		 * 
		 * --> 여러 타입의 bean이 존재하는 경우 자동연결 시 어떠한 빈을 주입할것인지에 대한 여부가 확실하지 않아서 에러가 발생한다.
		 * ----> @Autowired는 타입이 일치하는 객체를 자동으로 주입해주기 때문이다.
		 */
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section01.primary");
		
		/* pokemon type의 bean이 3개가 있기 때문에 @Autowired로 어떠한 bean을 주입할 것인지 모르기 때문에 에러가 발생한다.
		 * */
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
	}
}
