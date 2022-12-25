package com.greedy.section01.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // @Primary 어노테이션을 설정하면 @Autowired로 동일한 타입의 여러 빈을 찾게 되는 경우 자동연결을 우선시 할 타입으로 설정하는 것
         // 동일한 타입(Pokemon) 클래스 중 한개만 @Primary 어노테이션 사용이 가능하다.
public class Pikachu implements Pokemon{

	@Override
	public void attack() {
		
		System.out.println("피카츄가 공격을 합니다!! 백만볼트~~ 찌지지지지지직~~~");
	}

}
