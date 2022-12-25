package com.greedy.section03.subsection02.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Application {

	public static void main(String[] args) {
		
		/* cglib 방식 
		 * 동적 Proxy를 생성하지만 바이트코드를 조작하여 프록시를 생성해주는 방식
		 * 인터페이스 뿐 아니라 타겟의 클래스가 인터페이스를 구현하지 않아도 프록시를 생성해준다.
		 * 
		 * 두 방식의 차이점은 성능 차이인데 invoke시 성능이 차이가 나게 된다.
		 * CGLIb(Code Generator Library)의 경우에는 처음 메소드가 호출된 당시 동적으로 타겟 클래스의
		 * 바이트코드를 조작하게 되고 그 이후 호출시부터는 변경된 코드를 재사용한다.
		 * 
		 * 따라서 매번 검증 코드를 거치는 1번 방식보다는 성능면에서는 더 빠르게 된다.
		 * 또한 리플렉션에 의한 것이 아닌 바이트코드를 조작하는 방식이기 때문에 성능면에서는 더우수한 방식이었다.
		 * 
		 * 하지만 CGLib방식은 단점이 있었고, 스프링에서 기본적으로 제공되는 방식은 아니었기에 별도로 의존성(enhancer)을 추가하여
		 * 개발해야 했고, 파라미터가 없는 default 생성자가 반드시 필요했으며, 생성된 프록시의 메소드를 호출하면
		 * 타겟의 생성자가 2번 호출되는 문제점들이 있었다.
		 * 
		 * 스프링 4.3 스프링부터 1.3 이후부터 CGLib의 문제가 된 부분이 개선되어 기본 core패키지에 포함하게 되었고
		 * 스프링에서 기본적으로 사용하는 프록시 방식이 CGLib방식이 되었다.
		 * */
		
		GreedyStudent student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		// Enhancer 클래스의 create static 메소드는 타켓 클래스의 메타정보와 핸들러를 전달하면 proxy를 생성해서 반환한다.
		GreedyStudent proxy = (GreedyStudent) Enhancer.create(GreedyStudent.class, new Handler(new GreedyStudent()));
		
		proxy.study(20);
		
	}
}
