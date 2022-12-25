package com.greedy.section02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/* @Qualifier 어노테이션을 이용해서 원하는 객체를 주입 */
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section02.qualifier");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
	}
}
