package com.greedy.section05.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	/* @Inject어노테이션을 사용하려면 javax.inject-1.jar를 추가 
	 * 
	 * @Inject어노테이션은 @Autowired와 유사하게 타입을 이용해서 빈을 자동 연결한다.
	 * 마찬가지로 bean이 여러개이면 모호성으로 인해 의존성 주입을 할 수 없다.
	 * 컬렉션 형태로 변경을 하면 가능하다.
	 * */
	
	/* 1. 필드 주입 */		
	
//	@Inject
// //@Named("pikachu") // 같은 타입의 여러 빈을 collection으로 받았을 때 이걸로 bean을 선택할 수 있다.
//	@Qualifier("pikachu") // import를 할때 스프링용으로 적용 가능
//	private Pokemon pokemon;
	
	/* 2. 생성자 주입 */
//	private Pokemon pokemon;
	
//	@Inject
//	@Named("pikachu")
//	public PokemonService(Pokemon pokemon) {
//		
//		this.pokemon = pokemon;
//	}

	// 파라미터 레벨에서 사용 가능
//	@Inject
//	public PokemonService(@Named("pikachu") Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
	/* 3. setter 주입 */
	private Pokemon pokemon;
	
//	@Inject
//	@Named("pikachu")
//	public void setPokemon(Pokemon pokemon) {
//		
//		this.pokemon = pokemon;
//	}
	
	// 파라미터 레벨에서 사용가능
	@Inject
	public void setPokemon(@Named("pikachu") Pokemon pokemon) {
		
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		
		pokemon.attack();
	}
	
	
	
}
