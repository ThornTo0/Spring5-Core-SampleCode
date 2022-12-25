package com.greedy.section02.constinjection.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {


	private RandomGenerator random;

	/* 생성자 주입의 장점
	 * 1. 필드 주입이 간단하긴 하지만 단일책임의 원칙관점에서 볼 때 필드는 수많은 빈들을 주입받을 수 있다.
	 *    하지만 생성자 주입을 하게 되면 생성자의 매개변수가 많아지면서 이게 아닌데 라는 느낌을 받고 리팩토링을 할 수 있는 지표가 될 수 있다.
	 * 2. 필드에 final 키워드 사용이 가능해진다. 따라서 변경 불가능하게 사용할 수 있다.
	 * 3. 순환참조 방지(필드 주입이나 세터 주입의 경우 메소드 실행 시점에만 발생할 수 있지만, 생성자 주입을 하면 애플리케이션 실행시점에 확인가능하다.)
	 * 4. DI 컨테이너와 결합도가 낮기 때문에 테스트하기 좋다(스프링 컨테이너 없이 테스트를 할 수 있다.)
	 * */
	
	public MakeRandomString() {}
	
	/* 스프링 4.3 이후부터는 생성자에 주입할 시 생성자가 한 개뿐이라면 해당 생성자에 @Autowired어노테이션을 생략해도 자동으로 주입해준다.
	 * 하지만 기본생성자를 만들어보면 어노테이션을 생략했을 시 에러가 발생하게 된다. 생성자를 통해 필드에 객체가 주입되지 않았기 떄문에
	 * NullPointerException이 발생한다.
	 * 
	 * 여러개의 생성자가 있을 경우에는 명시적으로 @Autowired를 적어준다.
	 * */
	@Autowired
	public MakeRandomString(RandomGenerator random) {
		
		this.random = random;
	}
	
	public String getRandomLengthString() {
		
		StringBuilder sb = new StringBuilder();
		
		int randomNumber = random.getRandomNumber(); 
		for(int i = random.getStartNum(); i <= randomNumber; i++) {
			sb.append("*");
		}
		
		return sb.toString();
	}
}
