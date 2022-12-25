package com.greedy.section04.resource;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	/* @Resource어노테이션은 기본적으로 이름으로 주입받는다. 하지만 빈의 이름이 일치하지 않으면 타입으로 주입을 받는다.
	 * 하지만 동일한 타입의 bean이 있는 경우에는 주입받지 못한다.
	 * */
	
	/* 1. 같은 타입의 bean이 여러개 */
//	@Resource(name = "charmander")
//	private Pokemon pokemon;
//	
//	public void pokemonAttack() {
//		
//		pokemon.attack();
//	}
	
//	@Resource(name="charmander")
//	//@Qualifier("squirtle")
//	private List<Pokemon> pokemonList;
//	
//	public void pokemonAttack() {
//		
//		for(Pokemon pokemon : pokemonList) {
//			
//			pokemon.attack();
//		}
//	}
	
	/* bean이 한개일 때 
	 * @Resource어노테이션은 필드주입가능
	 * */
//	@Resource
//	private Pokemon pokemon;
//	
	
	/* @Resource어노테이션은 생성자 주입을 하지 못한다. (애초에 에러남)*/
//	private Pokemon pokemon;
//	
//	@Resource
//	public PokemonService(Pokemon pokemon) {
//		
//		this.pokemon = pokemon;
//	}
	
	/* @Resource어노테이션은 setter주입은 가능하다.*/
	private Pokemon pokemon;
	
	@Resource
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		
		pokemon.attack();
	}
	
	
	
}
